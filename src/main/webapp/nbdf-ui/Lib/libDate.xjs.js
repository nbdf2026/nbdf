//XJS=libDate.xjs
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
         ● gfn_isNull                           :  오늘 날짜를 nType형에 따라 데이터를 추출하는 함수
         */

        /**
         * @description		오늘 날짜를 nType형에 따라 데이터를 추출하는 함수
         * @param 			{nType			: Sting} 	입력값
         * @return 			{sReturnValue	: Sting} 	nType 유형에 따른 값 리턴
         */
        this.gfn_getDate = function(nType)
        {
        	var sReturnValue 	= "";
            var objDate 		= new Date();
        	var sYear			= objDate.getFullYear().toString();
        	var sMonth			= (objDate.getMonth() + 1).toString().padLeft(2, '0');
        	var sDay			= objDate.getDate().toString().padLeft(2, '0');

        	switch(nType) {
        		case "yyyy-mm-dd":
        			sReturnValue = sYear + "-" + sMonth + "-" + sDay;
        			break;
        		case "yyyymmdd":
        			sReturnValue = sYear + sMonth + sDay;
        			break;
        		case "yyyy-mm-01":
        			sReturnValue = sYear + "-" + sMonth + "-" + "01";
        			break;
        		case "yyyymm01":
        			sReturnValue = sYear + sMonth + "01";
        			break;
        		case "yyyy-mm":
        			sReturnValue = sYear + "-" + sMonth;
        			break;
        		case "yyyymm":
        			sReturnValue = sYear + sMonth;
        			break;
        		case "yyyy-01":
        			sReturnValue = sYear + '-' + '01';
        			break;
        		case "yyyy01":
        			sReturnValue = sYear + '01';
        			break;
        		case "yyyy":
        			sReturnValue = sYear;
        			break;
        		case "mm":
        			sReturnValue = sMonth;
        			break;
        		case "dd":
        			sReturnValue = sDay;
        			break;
        		default:
        			sReturnValue = "";
        			break;
        	}

        	return sReturnValue;
        };
        });
    
        this.loadIncludeScript(path);
        
        obj = null;
    };
}
)();
