var pForm 	= nexacro.Form.prototype;

/*
 ===============================================================================
 ==  Util 관련 공통 함수
 ===============================================================================
 ● this.gfn_isNull                      :  null 체크 함수
 ● this.gfn_msgBox						:  메시지ID를 기준으로 alert, confirm 메시지 출력
 */

/**
 * @description		null 체크 함수
 * @param 			{objValue		: String} 	입력값
 * @return 			{bReturnValue	: boolen} 	true, false
 */
pForm.gfn_isNull = function(objValue)
{
	var bReturnValue = false;
	
    // undefined 또는 null
    if (objValue === undefined || objValue === null) bReturnValue = true;
	
    // 공백 문자열
    if (String(objValue).trim() == "" || String(objValue).length == 0) bReturnValue = true;	

    return bReturnValue;
};

/**
 * @description		메시지ID를 기준으로 alert, confirm 메시지 출력
 * @param 			{sMessageNum	: String}  	메시지번호
 * @return 			{bReturnValue	: boolen} 	true, false
 */
pForm.gfn_msgBox = function(sMessageNum, arrArguments)
{
	var app   			= nexacro.getApplication();
	var gdsMsg			= app.gds_message;
	var sLanguageCd		= app.languageCd;
	var sMsgText 	 	= "";
	var sMsgType 	 	= "";
	var bReturnValue 	= false;

	trace("sLanguageCd : " + sLanguageCd);
	
	var nRow = gdsMsg.findRow("MESSAGE_NUM", sMessageNum);

	if (nRow >= 0) {
		if (pForm.gfn_isNull(sLanguageCd)) {
			sMsgText = gdsMsg.getColumn(nRow, "MESSAGE_TEXT_KO");
		} else {
			switch(sLanguageCd)	{
				case "KO":
					sMsgText = gdsMsg.getColumn(nRow, "MESSAGE_TEXT_KO");
					break;
				case "EN":
					sMsgText = gdsMsg.getColumn(nRow, "MESSAGE_TEXT_EN");
					break;
				case "ZH":
					sMsgText = gdsMsg.getColumn(nRow, "MESSAGE_TEXT_ZH");
					break;
				case "JA":
					sMsgText = gdsMsg.getColumn(nRow, "MESSAGE_TEXT_JA");
					break;
				default:
					sMsgText = "";
			}
		}
		
		// 메시지 치환
		if (!pForm.gfn_isNull(arrArguments))
		{
			for (var i=0; i<arrArguments.length; i++)
			{
				var reg = new RegExp("\\{" + (i + 1) + "\\}", "g");
				sMsgText = sMsgText.replace(reg, arrArguments[i]);
			}
		}
		
		sMsgType = gdsMsg.getColumn(nRow, "MESSAGE_TYPE_CD");
		if (sMsgType == "A") alert(sMsgText);
		else if (sMsgType == "C") bReturnValue = confirm(sMsgText);
	}
		
	return bReturnValue;
};
