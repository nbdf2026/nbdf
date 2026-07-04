package erp.core.nbdfutil.sqlparsing;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import lombok.extern.slf4j.Slf4j;

/**
* @packageName    : erp.core.sqlparsing
* @fileName       : SqlFormat.java
* @author         : Built1
* @date           : 2026.06.22
* @description    : 콘솔에 출력되는 쿼리 줄간격/들여쓰기 조정
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.22        Built1             최초 생성
*/
@Slf4j
public class SqlFormat implements MessageFormattingStrategy { 
	
	
	/**
	* @methodName     : splitCommaOutsideParentheses
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : 콤마 구분자로 분리된 쿼리 내용을 한문장으로 출력하는 메서드
	* @param sql
	* @return
	*/
	private String splitCommaOutsideParentheses(String sql) {

	    StringBuilder sb = new StringBuilder();

	    int depth = 0;

	    for (int i = 0; i < sql.length(); i++) {
	        char ch = sql.charAt(i);
	        
	        if (ch == '(') {
	            depth++;
	        }
	        else if (ch == ')') {
	            depth--;
	        }

	        if (ch == ',' && depth == 0) {
	            sb.append("\n     , ");

	            // 콤마 다음 공백 제거
	            while (i + 1 < sql.length() &&
	                   Character.isWhitespace(sql.charAt(i + 1))) {
	                i++;
	            }
	        }
	        else {
	            sb.append(ch);
	        }
	    }
	    return sb.toString();
	}
	
	/**
	* @methodName     : alignSelectAs
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : Select 문장의 As 줄간격 치환하는 메서드
	* @param sql
	* @return
	*/
	private String alignSelectAs(String sql) {

	    String[] lines = sql.split("\n");

	    int maxLen = 0;

	    // AS 앞 최대 길이 계산
	    for (String line : lines) {

	        String upper = line.toUpperCase();

	        if (upper.contains(" AS ")) {

	            String expr =
	                line.substring(0, upper.indexOf(" AS ")).trim();

	            maxLen = Math.max(maxLen, expr.length());
	        }
	    }

	    StringBuilder sb = new StringBuilder();

	    for (String line : lines) {

	        String upper = line.toUpperCase();

	        if (upper.contains(" AS ")) {

	            int idx = upper.indexOf(" AS ");

	            String leftPart = line.substring(0, idx);
	            String alias = line.substring(idx + 4).trim();

	            // 들여쓰기 추출
	            String indent = leftPart.replaceAll("^([^\\S\\r\\n]*).*", "$1");

	            String expr = leftPart.trim();

	            sb.append(indent);
	            sb.append(String.format("%-" + maxLen + "s AS %s", expr, alias));
	        }
	        else {
	            sb.append(line);
	        }

	        sb.append("\n");
	    }

	    return sb.toString();
	}
	
	/**
	* @methodName     : alignUpdateSet
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : Update 문장의 "=" 간격을 일정 길이로 치환하는 메서드
	* @param sql
	* @return
	*/
	private String alignUpdateSet(String sql) {

	    String[] lines = sql.split("\n");

	    int maxLen = 0;

	    // SET 컬럼 길이 계산
	    for (String line : lines) {

	        String trim = line.trim().toUpperCase();

	        if (trim.startsWith("SET ")
	            || trim.startsWith(",")) {

	            int idx = line.indexOf("=");

	            if (idx > 0) {

	                String left = line.substring(0, idx)
	                                  .replaceFirst("(?i)^\\s*SET\\s+", "")
	                                  .replaceFirst("^\\s*,\\s*", "")
	                                  .trim();

	                maxLen = Math.max(maxLen, left.length());
	            }
	        }
	    }

	    StringBuilder sb = new StringBuilder();

	    for (String line : lines) {

	        String trim = line.trim().toUpperCase();

	        // SET 절만 정렬
	        if ((trim.startsWith("SET ") || trim.startsWith(","))
	                && line.contains("=")) {

	            int idx = line.indexOf("=");

	            String left = line.substring(0, idx)
	                              .replaceFirst("(?i)^\\s*SET\\s+", "")
	                              .replaceFirst("^\\s*,\\s*", "")
	                              .trim();

	            String right = line.substring(idx + 1).trim();

	            if (trim.startsWith("SET ")) {

	                sb.append(String.format(
	                        "   SET %-" + maxLen + "s = %s",
	                        left,
	                        right));

	            } else {

	                sb.append(String.format(
	                        "     , %-" + maxLen + "s = %s",
	                        left,
	                        right));
	            }

	        } else {

	            // WHERE, AND, OR, UPDATE 등은 그대로 출력
	            sb.append(line);
	        }

	        sb.append("\n");
	    }

	    return sb.toString();
	}
	
	/**
	* @methodName     : alignWhereCondition
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : where 조건절 들여쓰기 처리하는 메서드
	* @param sql
	* @return
	*/
	private String alignWhereCondition(String sql) {

	    String[] lines = sql.split("\n");

	    int maxLen = 0;

	    for (String line : lines) {

	        String trim = line.trim().toUpperCase();

	        if (trim.startsWith("WHERE ")
	                || trim.startsWith("AND ")
	                || trim.startsWith("OR ")) {

	            String expr = line;

	            expr = expr.replaceFirst("(?i)^\\s*WHERE\\s+", "");
	            expr = expr.replaceFirst("(?i)^\\s*AND\\s+", "");
	            expr = expr.replaceFirst("(?i)^\\s*OR\\s+", "");

	            String[] ops = { "<=", ">=", "<>", "!=", "=", "<", ">" };

	            for (String op : ops) {

	                int idx = expr.indexOf(op);

	                if (idx > 0) {
	                    maxLen = Math.max(maxLen,
	                            expr.substring(0, idx).trim().length());
	                    break;
	                }
	            }
	        }
	    }

	    StringBuilder sb = new StringBuilder();

	    for (String line : lines) {

	        String upper = line.trim().toUpperCase();

	        if (upper.startsWith("WHERE ")
	                || upper.startsWith("AND ")
	                || upper.startsWith("OR ")) {

	            String prefix = "";

	            if (upper.startsWith("WHERE ")) {
	                prefix = " WHERE ";
	            } else if (upper.startsWith("AND ")) {
	                prefix = "   AND ";
	            } else {
	                prefix = "    OR ";
	            }

	            String expr = line.trim()
	                    .replaceFirst("(?i)^WHERE\\s+", "")
	                    .replaceFirst("(?i)^AND\\s+", "")
	                    .replaceFirst("(?i)^OR\\s+", "");

	            String[] ops = { "<=", ">=", "<>", "!=", "=", "<", ">" };

	            boolean found = false;

	            for (String op : ops) {

	                int idx = expr.indexOf(op);

	                if (idx > 0) {

	                    String left = expr.substring(0, idx).trim();
	                    String right = expr.substring(idx + op.length()).trim();

	                    sb.append(prefix)
	                      .append(String.format(
	                              "%-" + maxLen + "s %s %s",
	                              left,
	                              op,
	                              right));

	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                sb.append(line);
	            }
	        }
	        else {
	            sb.append(line);
	        }

	        sb.append("\n");
	    }

	    return sb.toString();
	}
	
	/**
	* @methodName     : alignJoinCondition
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : 조인 문장 들여쓰기 처리하는 메서드
	* @param sql
	* @return
	*/
	private String alignJoinCondition(String sql) {

	    String[] lines = sql.split("\n");

	    int maxLen = 0;

	    for (String line : lines) {

	        String trim = line.trim().toUpperCase();

	        if (trim.startsWith("ON ")) {

	            String expr = trim.substring(3);

	            int idx = expr.indexOf("=");

	            if (idx > 0) {
	                maxLen = Math.max(maxLen,
	                        expr.substring(0, idx).trim().length());
	            }
	        }
	    }

	    StringBuilder sb = new StringBuilder();

	    for (String line : lines) {

	        String trim = line.trim().toUpperCase();

	        if (trim.startsWith("ON ")) {

	            String expr = line.trim().substring(3);

	            int idx = expr.indexOf("=");

	            if (idx > 0) {

	                String left = expr.substring(0, idx).trim();
	                String right = expr.substring(idx + 1).trim();

	                sb.append("   ON ")
	                  .append(String.format(
	                          "%-" + maxLen + "s = %s",
	                          left,
	                          right));
	            }
	            else {
	                sb.append(line);
	            }
	        }
	        else {
	            sb.append(line);
	        }

	        sb.append("\n");
	    }

	    return sb.toString();
	}
	
	/**
	* @methodName     : alignCaseWhen
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : case when 들여쓰기 처리하는 메서드
	* @param sql
	* @return
	*/
	private String alignCaseWhen(String sql) {

	    sql = sql.replaceAll("(?i)\\s+case\\s+", "\n       CASE ");
	    sql = sql.replaceAll("(?i)\\s+when\\s+", "\n            WHEN ");
	    sql = sql.replaceAll("(?i)\\s+then\\s+", " THEN ");
	    sql = sql.replaceAll("(?i)\\s+else\\s+", "\n            ELSE ");
	    sql = sql.replaceAll("(?i)\\s+end\\s+", "\n       END ");

	    return sql;
	}

	/**
	* @methodName     : formatMessage
	* @author         : built1
	* @date           : 2026.06.22
	* @description    : 콘솔에 쿼리 문장을 출력하는 상속메서드
	* @param connectionId
	* @param now
	* @param elapsed
	* @param category
	* @param prepared
	* @param sql
	* @param url
	* @return
	*/
	@Override
    public String formatMessage(int connectionId, String now, long elapsed,
            String category, String prepared, String sql, String url) {

        if (sql == null || sql.trim().isEmpty()) {
            return "";
        }

        return "\n\n/* SQL 실행시간 : " + elapsed + " ms */\n"
                + pretty(sql)
                + "\n";
    }

    /**
    * @methodName     : pretty
    * @author         : built1
    * @date           : 2026.06.22
    * @description    : 쿼리 문장을 들여쓰기/줄간격 변환하는 함수
    * @param sql
    * @return
    */
    private String pretty(String sql) {
        String text = sql.replaceAll("\\s+", " ").trim();
        String lower = text.toLowerCase();
        
        text = text.replaceAll("(?i)\\s+from\\s+", "\n  FROM ");
        text = text.replaceAll("(?i)\\s+left\\s+join\\s+", "\n LEFT JOIN ");
        text = text.replaceAll("(?i)\\s+right\\s+join\\s+", "\n RIGHT JOIN ");
        text = text.replaceAll("(?i)\\s+inner\\s+join\\s+", "\n INNER JOIN ");
        text = text.replaceAll("(?i)\\s+join\\s+", "\n JOIN ");
        text = text.replaceAll("(?i)\\s+on\\s+", "\n   ON ");
        text = text.replaceAll("(?i)\\s+where\\s+", "\n WHERE ");
        text = text.replaceAll("(?i)\\s+and\\s+", "\n   AND ");
        text = text.replaceAll("(?i)\\s+or\\s+", "\n    OR ");
        text = text.replaceAll("(?i)\\s+order\\s+by\\s+", "\n ORDER BY ");
        text = text.replaceAll("(?i)\\s+group\\s+by\\s+", "\n GROUP BY ");
        text = text.replaceAll("(?i)\\s+having\\s+", "\n HAVING ");
        
        // SELECT
        if (lower.startsWith("select ")) {
            text = text.replaceFirst("(?i)^select\\s+", "SELECT\n       ");
            text = splitCommaOutsideParentheses(text);
            text = alignSelectAs(text);
            text = alignJoinCondition(text);
            text = alignWhereCondition(text);
            text = alignCaseWhen(text);
            text = text.replaceAll("WHERE\\s+1\\s*=\\s*1", "WHERE 1=1");
        }

        // UPDATE
        else if (lower.startsWith("update ")) {
        	text = text.replaceFirst("(?i)^update\\s+", "UPDATE ");
            text = text.replaceAll("(?i)\\s+set\\s+", "\n   SET ");
            text = splitCommaOutsideParentheses(text);
            text = alignUpdateSet(text);
            text = alignWhereCondition(text);
            text = text.replaceAll("WHERE\\s+1\\s*=\\s*1", "WHERE 1=1");
        }

        // DELETE
        else if (lower.startsWith("delete ") || lower.startsWith("delete")) {
        	text = text.replaceFirst("(?i)^delete\\s+", "DELETE ");
            text = text.replaceAll("(?i)\\s+from\\s+", "\n  FROM ");
            text = alignWhereCondition(text);
            text = text.replaceAll("WHERE\\s+1\\s*=\\s*1", "WHERE 1=1");
        }

        // INSERT
        else if (lower.startsWith("insert ")) {
            text = text.replaceFirst("(?i)^insert\\s+into\\s+", "INSERT INTO ");
            text = text.replaceAll("(?i)\\s+values\\s*\\(", "\nVALUES (\n       ");
            text = splitCommaOutsideParentheses(text);
        }
        
		/* Ctlr + Shift + /   or   Ctlr + Shift + \
		 * log.info("############################################################");
		 * log.debug("SqlFormat Class / pretty mothod ");
		 * log.info("############################################################");
		 * log.debug("Sql Text:\n" + text);
		 * log.info("############################################################");
		 */
		
        return text;
    }
}
