package erp.cmmn.log;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class PrettySqlFormat implements MessageFormattingStrategy {

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

    private String pretty(String sql) {
        String text = sql.replaceAll("\\s+", " ").trim();
        
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

        if (text.toLowerCase().startsWith("select ")) {
            text = text.replaceFirst("(?i)^select\\s+", "SELECT\n       ");
            text = text.replaceAll(",\\s*", "\n     , ");
        }

        return text;
    }
}
