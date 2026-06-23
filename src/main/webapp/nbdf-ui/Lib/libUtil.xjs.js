//XJS=libUtil.xjs
(function()
{
    return function(path)
    {
        var obj;
    
        // User Script
        this.registerScript(path, function() {
        /*
         ===============================================================================
         ==  Util 관련 공통 함수
         ===============================================================================
         ● gfn_isNull                           :  null 체크 함수
         */

        /**
         * @description		null 체크 함수
         * @param 			{objValue		: String} 	입력값
         * @return 			{bReturnValue	: boolen} 	true, false
         */
        this.gfn_isNull = function(objValue)
        {
        	var bReturnValue = false;

            // undefined 또는 null
            if (objValue === undefined || objValue === null) bReturnValue = true;

            // 공백 문자열
            if (String(objValue).trim() == "" || String(objValue).length == 0) bReturnValue = true;

            return bReturnValue;
        };
        });
    
        this.loadIncludeScript(path);
        
        obj = null;
    };
}
)();
