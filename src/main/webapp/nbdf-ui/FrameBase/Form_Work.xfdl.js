(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_search", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "CODE_TYPE","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_codeType", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "CODE_TYPE","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM","type" : "STRING","size" : "256"},{"id" : "CODE_TYPE_NM_S","type" : "STRING","size" : "256"},{"id" : "START_DATE","type" : "STRING","size" : "256"},{"id" : "END_DATE","type" : "STRING","size" : "256"},{"id" : "CREATE_TYPE_CD","type" : "STRING","size" : "256"},{"id" : "REMARK","type" : "STRING","size" : "256"},{"id" : "CREATE_DATE","type" : "STRING","size" : "256"},{"id" : "CREATE_BY","type" : "STRING","size" : "256"},{"id" : "UPDATE_DATE","type" : "STRING","size" : "256"},{"id" : "UPDATE_BY","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_code", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "CODE_TYPE","type" : "STRING","size" : "256"},{"id" : "CODE","type" : "STRING","size" : "256"},{"id" : "CODE_NM","type" : "STRING","size" : "256"},{"id" : "CODE_NM_S","type" : "STRING","size" : "256"},{"id" : "START_DATE","type" : "STRING","size" : "256"},{"id" : "END_DATE","type" : "STRING","size" : "256"},{"id" : "REMARK","type" : "STRING","size" : "256"},{"id" : "CREATE_DATE","type" : "STRING","size" : "256"},{"id" : "CREATE_BY","type" : "STRING","size" : "256"},{"id" : "UPDATE_DATE","type" : "STRING","size" : "256"},{"id" : "UPDATE_BY","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_message", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "MESSAGE_NUM","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TYPE_CD","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TEXT_KO","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TEXT_EN","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TEXT_ZH","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TEXT_JA","type" : "STRING","size" : "256"},{"id" : "MESSAGE_TEXT_OT","type" : "STRING","size" : "256"},{"id" : "REMARK","type" : "STRING","size" : "256"},{"id" : "CREATE_DATE","type" : "STRING","size" : "256"},{"id" : "CREATE_BY","type" : "STRING","size" : "256"},{"id" : "UPDATE_DATE","type" : "STRING","size" : "256"},{"id" : "UPDATE_BY","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_user", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "USER_ID","type" : "STRING","size" : "256"},{"id" : "USER_NAME","type" : "STRING","size" : "256"},{"id" : "EMAIL_ADDRESS","type" : "STRING","size" : "256"},{"id" : "MOBILE_NUMBER","type" : "STRING","size" : "256"},{"id" : "COMPANY_CODE","type" : "STRING","size" : "256"},{"id" : "COMPANY_NAME","type" : "STRING","size" : "256"},{"id" : "BUSINESS_PLACE_CODE","type" : "STRING","size" : "256"},{"id" : "BUSINESS_PLACE_NAME","type" : "STRING","size" : "256"},{"id" : "DEPT_CODE","type" : "STRING","size" : "256"},{"id" : "DEPT_NAME","type" : "STRING","size" : "256"},{"id" : "JOB_CODE","type" : "STRING","size" : "256"},{"id" : "JOB_NAME","type" : "STRING","size" : "256"},{"id" : "POSITION_CODE","type" : "STRING","size" : "256"},{"id" : "POSITION_NAME","type" : "STRING","size" : "256"}]}});
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_language", this);
            obj._setContents({"ColumnInfo" : {"Column" : [ {"id" : "LANGUAGE_CODE","type" : "STRING","size" : "256"},{"id" : "LANGUAGE_NAME","type" : "STRING","size" : "256"}]},"Rows" : [{"LANGUAGE_CODE" : "KO","LANGUAGE_NAME" : "한국어"},{"LANGUAGE_CODE" : "EN","LANGUAGE_NAME" : "English"}]});
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Button("btn_search","20","70","120","40",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Grid("grd_codeType","20","120","480","580",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_binddataset("ds_codeType");
            obj.set_autofittype("col");
            obj.set_autosizingtype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"131\"/><Column size=\"128\"/><Column size=\"110\"/><Column size=\"110\"/><Column size=\"69\"/></Columns><Rows><Row size=\"30\" band=\"head\"/><Row size=\"30\"/></Rows><Band id=\"head\"><Cell text=\"코드유형\"/><Cell col=\"1\" text=\"코드유형명\"/><Cell col=\"2\" text=\"시작일자\"/><Cell col=\"3\" text=\"종료일자\"/><Cell col=\"4\" text=\"수정자\"/></Band><Band id=\"body\"><Cell text=\"bind:CODE_TYPE\" edittype=\"text\" displaytype=\"editcontrol\"/><Cell col=\"1\" text=\"bind:CODE_TYPE_NM\" edittype=\"text\" displaytype=\"editcontrol\"/><Cell col=\"2\" text=\"bind:START_DATE\" calendardateformat=\"yyyy-MM-dd\" edittype=\"date\" displaytype=\"calendarcontrol\" textAlign=\"center\" calendardisplaynulltype=\"none\"/><Cell col=\"3\" text=\"bind:END_DATE\" calendardateformat=\"yyyy-MM-dd\" edittype=\"date\" displaytype=\"calendarcontrol\" textAlign=\"center\" calendardisplaynulltype=\"none\"/><Cell col=\"4\" text=\"bind:UPDATE_BY\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_delete","150","70","120","40",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            obj = new Button("btn_save","280","70","120","40",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("저장");
            this.addChild(obj.name, obj);

            obj = new Button("btn_gfnGetDate","464","70","195","40",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("gfn_getDate");
            this.addChild(obj.name, obj);

            obj = new Button("btn_login","664","70","195","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("로그인");
            this.addChild(obj.name, obj);

            obj = new Grid("grd_message","520","120","740","300",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("ds_message");
            obj.set_autofittype("col");
            obj.set_autosizingtype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"152\"/><Column size=\"190\"/><Column size=\"210\"/><Column size=\"179\"/><Column size=\"125\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"MESSAGE_NUM\"/><Cell col=\"1\" text=\"MESSAGE_TYPE_CD\"/><Cell col=\"2\" text=\"MESSAGE_TEXT_KO\"/><Cell col=\"3\" text=\"MESSAGE_TEXT_EN\"/><Cell col=\"4\" text=\"REMARK\"/></Band><Band id=\"body\"><Cell text=\"bind:MESSAGE_NUM\"/><Cell col=\"1\" text=\"bind:MESSAGE_TYPE_CD\"/><Cell col=\"2\" text=\"bind:MESSAGE_TEXT_KO\"/><Cell col=\"3\" text=\"bind:MESSAGE_TEXT_EN\"/><Cell col=\"4\" text=\"bind:REMARK\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_alertMessage","864","70","195","40",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("gfnMsgBox(gds메시지-Alert)");
            this.addChild(obj.name, obj);

            obj = new Button("btn_confirmMessage","1064","70","195","40",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("gfnMsgBox(gds메시지-Confirm)");
            this.addChild(obj.name, obj);

            obj = new Grid("grd_user","520","430","740","150",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_binddataset("ds_user");
            obj.set_autofittype("col");
            obj.set_autosizingtype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"114\"/><Column size=\"173\"/><Column size=\"241\"/><Column size=\"204\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"USER_ID\"/><Cell col=\"1\" text=\"USER_NAME\"/><Cell col=\"2\" text=\"EMAIL_ADDRESS\"/><Cell col=\"3\" text=\"MOBILE_NUMBER\"/></Band><Band id=\"body\"><Cell text=\"bind:USER_ID\"/><Cell col=\"1\" text=\"bind:USER_NAME\"/><Cell col=\"2\" text=\"bind:EMAIL_ADDRESS\"/><Cell col=\"3\" text=\"bind:MOBILE_NUMBER\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Radio("rdo_language","897","8","146","20",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_innerdataset("ds_language");
            obj.set_codecolumn("LANGUAGE_CODE");
            obj.set_datacolumn("LANGUAGE_NAME");
            obj.set_columncount("2");
            obj.set_text("한국어");
            obj.set_value("KO");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("edt_loginId","665","5","140","26",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_value("20000001");
            obj.set_text("20000001");
            this.addChild(obj.name, obj);

            obj = new Static("sta_loginID","580","5","80","26",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("로그인ID");
            this.addChild(obj.name, obj);

            obj = new Button("btn_gridColIndex","520","595","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("그리드컬럼인덱스");
            this.addChild(obj.name, obj);

            obj = new Button("btn_gridValue","771","600","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            obj.set_text("Button00");
            this.addChild(obj.name, obj);

            obj = new Static("sta_password","580","34","80","26",null,null,null,null,null,null,this);
            obj.set_taborder("15");
            obj.set_text("비밀번호");
            this.addChild(obj.name, obj);

            obj = new Edit("edt_password","665","34","140","26",null,null,null,null,null,null,this);
            obj.set_taborder("16");
            obj.set_password("true");
            obj.set_tooltiptext("대소문자 구분합니다.");
            obj.set_value("adminADMIN0101!@");
            obj.set_text("adminADMIN0101!@");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        var app     	= nexacro.getApplication();
        var gdsMsg  	= app.gds_message;
        var gdsUser 	= app.gds_user;
        var sUserId     = "";
        var sUserName   = "";

        this.Form_Work_onload = function(obj,e)
        {
        	app.languageCd = this.rdo_language.value;
        };


        this.fn_search = function(obj,e)
        {
        	this.ds_search.clearData();
        	var nRow = this.ds_search.addRow();
        	//this.ds_search.setColumn(nRow, "CODE_TYPE"   , "CREATE_TYPE_CD");
        	//this.ds_search.setColumn(nRow, "CODE_TYPE_NM", "생성");

        	var sSvcID 			= "selectCodeList";
        	var sSvcURL			= "svcUrl::com/COM10000M/selectCodeList.do";
        	var sInDatasets 	= "inSearch=ds_search";
        	var sOutDatasets 	= "ds_codeType=outSelectCodeTypeList";
        	var sArgument 		= "userId=" + app.userId;
        	var sCallbackFunc 	= "fn_callback";

        	// 공통코드 조회
        	this.gfn_transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);
        };

        this.fn_delete = function(obj,e)
        {
        	this.ds_codeType.deleteRow(this.ds_codeType.rowposition);
        };

        this.fn_save = function(obj,e)
        {
        	if(this.gfn_dataSetChange(this.ds_codeType) == false) {
        		this.gfn_msgBox("MSG-A-10020"); //변경된 데이터가 존재하지 않습니다.
        		return;
        	}

        	//그리드 필수항목 체크
        	var arrRequired = ["CODE_TYPE", "CODE_TYPE_NM", "START_DATE"];
        	if (!this.gfn_checkRequired(this.grd_codeType, arrRequired)) return;

        	var sSvcID 			= "saveCodeData";
        	var sSvcURL			= "svcUrl::com/COM10000M/saveCodeData.do";
        	var sInDatasets 	= "inCodeType=ds_codeType:U inCode=ds_code:U ";
        	var sOutDatasets 	= "";
        	var sArgument 		= "userId=" + app.userId;
        	var sCallbackFunc 	= "fn_callback";

        	// 공통코드 조회
        	//this.transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);
        	this.gfn_transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);
        };

        this.Button00_onclick = function(obj,e)
        {
        	trace(this.ds_codeType.saveXML());
        	alert(this.gfn_getDate("yyyymmdd"));

        	alert(this.gfn_isNull(""));
        };

        //메시지 조회
        this.fn_message = function(obj,e)
        {
        	var sUserID         = this.edt_loginId.value;
        	var sUserPassword   = this.edt_password.value;

        	var sSvcID 			= "selectMessageList";
        	var sSvcURL			= "svcUrl::com/COM10010M/selectMessageList.do";
        	var sInDatasets 	= "";
        	var sOutDatasets 	= "ds_message=outSelectMessageList ds_user=outSelectUserList";
        	var sArgument 		= "userId=" + sUserID + ' userPassword=' + sUserPassword;
        	var sCallbackFunc 	= "fn_callback";

        	// 공통코드 조회
        	this.gfn_transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);

        };

        //공통함수를 통한 gds alert 메시지 조회
        this.fn_alertMessage = function(obj,e)
        {
        	this.gfn_msgBox("MSG-A-10000"); //정상적으로 처리 되었습니다.
        };

        this.fn_confirmMessage = function(obj,e)
        {
        	var bYesNo = this.gfn_msgBox("MSG-C-10000"); //선택된 데이터를 삭제하시겠습니까?
        	if(bYesNo) alert("확인버튼클릭");
        	else alert("취소버튼클릭");
        };

        //콜백 함수
        this.fn_callback = function(sSvcID, nErrCd, sErrMsg)
        {
        	if(nErrCd < 0) {
        		alert(sErrMsg);
        		return;
        	}

        	switch(sSvcID) {
        		case "selectCodeList":
        			//trace("###########################################################");
        			//trace(this.ds_codeType.saveXML());
        			//trace("###########################################################");

        			var nCnt = this.ds_codeType.rowcount;
        			if (nCnt == 0) {
        				this.gfn_msgBox('MSG-A-10030'); //조회조건에 일치하는 데이터가 존재하지 않습니다.
        			}
        			break;

        		case "saveCodeData":
        			//trace("###########################################################");
        			//trace(this.ds_codeType.saveXML());
        			//trace("###########################################################");
        			this.gfn_msgBox('MSG-A-10000'); //정상적으로 저장 되었습니다.
        			this.fn_search();
        			break;

        		case "selectMessageList":
        			//trace("###########################################################");
        			//trace(this.ds_message.saveXML());
        			//trace("###########################################################");
        			//var app = nexacro.getApplication();
        			//var gdsMsg = app.gds_message;

        			if (!gdsMsg) {
        				this.gfn_msgBox('MSG-A-10040'); //공통 메시지정보(gds_message)가 생성되지 않았습니다.
        				return;
        			}
        			gdsMsg.clearData();
        			gdsMsg.copyData(this.ds_message);

        			if (!gdsUser) {
        				this.gfn_msgBox('MSG-A-10050'); //공통 사용자정보(gds_user)가 생성되지 않았습니다.
        				return;
        			}
        			gdsUser.clearData();
        			gdsUser.copyData(this.ds_user);

        			//글러벌 DataSet
        			sUserId   = gdsUser.getColumn(0, "USER_ID");
        			sUserName = gdsUser.getColumn(0, "USER_NAME");

        			//글로벌 변수
        			app.userId 	 = sUserId;
        			app.userName = sUserName;

        			//삼항연산자
        			var sJobCode = gdsUser.getColumn(0, "EMAIL_ADDRESS");
        			sJobCode = this.gfn_isNull(sJobCode) ? "" : sJobCode;
        			//alert("사용자ID : " + sUserId + ", 사용자명 : " + sUserName);
        			//alert("직무코드 : " + sJobCode);
        			//alert("app.userId : " + app.userId);

        			break;
        		}
        };


        this.rdo_language_onitemchanged = function(obj,e)
        {
        	app.languageCd = this.rdo_language.value;
        	alert("app.languageCd : " + app.languageCd);
        };


        this.btn_gridColIndex_onclick = function(obj,e)
        {
        	//그리드 컬럼이름을 기준으로 인덱스 찾기
        	//var nColumnIndex = this.gfn_getGridColumnIndex(this.grd_codeType, "CODE_TYPE_NM");
        	//alert("nColumnIndex : " + nColumnIndex);

        	//그리드 인덱스를 기준으로 헤더 텍스트 찾기
        	//if (nColumnIndex>0) {
        	//	var sColumnHeaderText = this.gfn_getGridHeaderText(this.grd_codeType, nColumnIndex);
        	//	alert(sColumnHeaderText);

        		//그리드 필수항목 체크
        		var arrRequired = ["CODE_TYPE", "CODE_TYPE_NM", "START_DATE"];
        		if (!this.gfn_checkRequired(this.grd_codeType, arrRequired)) return;
        	//}
        };

        this.btn_gridValue_onclick = function(obj,e)
        {
        	var sColumnBandName = "CODE_TYPE";
        	var sColumnValue = this.ds_codeType.getColumn(1, sColumnBandName);

            alert("sColumnValue : " + sColumnValue);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_Work_onload,this);
            this.btn_search.addEventHandler("onclick",this.fn_search,this);
            this.btn_delete.addEventHandler("onclick",this.fn_delete,this);
            this.btn_save.addEventHandler("onclick",this.fn_save,this);
            this.btn_gfnGetDate.addEventHandler("onclick",this.Button00_onclick,this);
            this.btn_login.addEventHandler("onclick",this.fn_message,this);
            this.btn_alertMessage.addEventHandler("onclick",this.fn_alertMessage,this);
            this.btn_confirmMessage.addEventHandler("onclick",this.fn_confirmMessage,this);
            this.rdo_language.addEventHandler("onitemchanged",this.rdo_language_onitemchanged,this);
            this.btn_gridColIndex.addEventHandler("onclick",this.btn_gridColIndex_onclick,this);
            this.btn_gridValue.addEventHandler("onclick",this.btn_gridValue_onclick,this);
        };
        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
