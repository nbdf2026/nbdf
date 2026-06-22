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
         * @return 			{bDsChange		: boolen} 	true, false
         */
        this.gfn_isNull = function(objValue)
        {
            // undefined 또는 null
            if (objValue === "undefined" || objValue === null) {
                return true;
            }

            // 숫자형 NaN
        //     if (typeof objValue == number && isNaN(objValue)) {
        //         return true;
        //     }

            // 공백 문자열
            if (String(objValue).trim() == "") {
                return true;
            }

            return false;
        };
        });
    
        this.loadIncludeScript(path);
        
        obj = null;
    };
}
)();
