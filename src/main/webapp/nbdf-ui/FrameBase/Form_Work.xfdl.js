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

            obj = new Button("Button00","537","74","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("Button00");
            this.addChild(obj.name, obj);

            obj = new Button("btn_message","740","70","120","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("메시지(gds복사)");
            this.addChild(obj.name, obj);

            obj = new Grid("grd_codeType00","520","120","740","580",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_binddataset("ds_message");
            obj.set_autofittype("col");
            obj.set_autosizingtype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"152\"/><Column size=\"190\"/><Column size=\"210\"/><Column size=\"179\"/><Column size=\"125\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"MESSAGE_NUM\"/><Cell col=\"1\" text=\"MESSAGE_TYPE_CD\"/><Cell col=\"2\" text=\"MESSAGE_TEXT_KO\"/><Cell col=\"3\" text=\"MESSAGE_TEXT_EN\"/><Cell col=\"4\" text=\"REMARK\"/></Band><Band id=\"body\"><Cell text=\"bind:MESSAGE_NUM\"/><Cell col=\"1\" text=\"bind:MESSAGE_TYPE_CD\"/><Cell col=\"2\" text=\"bind:MESSAGE_TEXT_KO\"/><Cell col=\"3\" text=\"bind:MESSAGE_TEXT_EN\"/><Cell col=\"4\" text=\"bind:REMARK\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("btn_alertMessage","880","70","150","40",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("alert(gds메시지조회)");
            this.addChild(obj.name, obj);

            obj = new Button("btn_confirmMessage","1040","70","150","40",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("alert(gds메시지조회)");
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

        var app    = nexacro.getApplication();
        var gdsMsg = app.gds_message;
        var userId = "built1";
        var sLanguageCd = "KO";

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
        	var sArgument 		= "userId=" + this.userId;
        	var sCallbackFunc 	= "fn_callback";

        	// 공통코드 조회
        	this.gfn_transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);
        };

        this.fn_callback = function(sSvcID, nErrCd, sErrMsg)
        {
        	if(nErrCd < 0) {
        		alert("오류 : " + sErrMsg);
        		return;
        	}

        	switch(sSvcID) {
        		case "selectCodeList":
        			//trace("###########################################################");
        			//trace(this.ds_codeType.saveXML());
        			//trace("###########################################################");

        			var nCnt = this.ds_codeType.rowcount;
        			if (nCnt == 0) {
        				alert("조회조건에 일치하는 데이터가 존재하지 않습니다.");
        			}
        			break;

        		case "saveCodeData":
        			//trace("###########################################################");
        			//trace(this.ds_codeType.saveXML());
        			//trace("###########################################################");
        			alert("정상적으로 처리되었습니다.");
        			this.fn_search();
        			break;

        		case "selectMessageList":
        			//trace("###########################################################");
        			//trace(this.ds_message.saveXML());
        			//trace("###########################################################");
        			//var app = nexacro.getApplication();
        			//var gdsMsg = app.gds_message;

        			if (!gdsMsg) {
        				trace("gds_message가 아직 생성되지 않았습니다.");
        				return;
        			}

        			gdsMsg.clearData();
        			gdsMsg.copyData(this.ds_message);
        			break;
        		}
        };

        this.fn_delete = function(obj,e)
        {
        	this.ds_codeType.deleteRow(this.ds_codeType.rowposition);
        };

        this.fn_save = function(obj,e)
        {
        	if(this.gfn_dataSetChange(this.ds_codeType) == false) {
        		alert("변경된 데이터가 존재하지 않습니다.");
        		return;
        	}

        	for(var i=0; i<this.ds_codeType.rowcount; i++) {
        		//데이터셋 초기상태일 경우 Skip
        		if(this.ds_codeType.getRowType(i)==Dataset.ROWTYPE_NORMAL) continue;

        		if (this.gfn_isNull(this.ds_codeType.getColumn(i, "CODE_TYPE"))) {
        			alert("코드유형 항목은 필수입니다.");
        			return;
        		}
        	}

        	var sSvcID 			= "saveCodeData";
        	var sSvcURL			= "svcUrl::com/COM10000M/saveCodeData.do";
        	var sInDatasets 	= "inCodeType=ds_codeType:U inCode=ds_code:U ";
        	var sOutDatasets 	= "";
        	var sArgument 		= "userId=" + this.userId;
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
        	this.ds_message.clearData();
        	//this.ds_search.clearData();
        	//var nRow = this.ds_search.addRow();
        	//this.ds_search.setColumn(nRow, "CODE_TYPE"   , "CREATE_TYPE_CD");
        	//this.ds_search.setColumn(nRow, "CODE_TYPE_NM", "생성");

        	var sSvcID 			= "selectMessageList";
        	var sSvcURL			= "svcUrl::com/COM10010M/selectMessageList.do";
        	var sInDatasets 	= "";
        	var sOutDatasets 	= "ds_message=outSelectMessageList";
        	var sArgument 		= "";
        	var sCallbackFunc 	= "fn_callback";

        	// 공통코드 조회
        	this.gfn_transaction(sSvcID, sSvcURL, sInDatasets, sOutDatasets, sArgument, sCallbackFunc);

        };

        //공통함수를 통한 gds alert 메시지 조회
        this.fn_alertMessage = function(obj,e)
        {
        	this.gfn_msgBox("MSG-A-10000", sLanguageCd);
        };

        this.fn_confirmMessage = function(obj,e)
        {
        	var bYesNo = this.gfn_msgBox("MSG-C-10000", sLanguageCd);
        	if(bYesNo) alert("확인버튼클릭");
        	else alert("취소버튼클릭");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.btn_search.addEventHandler("onclick",this.fn_search,this);
            this.btn_delete.addEventHandler("onclick",this.fn_delete,this);
            this.btn_save.addEventHandler("onclick",this.fn_save,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.btn_message.addEventHandler("onclick",this.fn_message,this);
            this.btn_alertMessage.addEventHandler("onclick",this.fn_alertMessage,this);
            this.btn_confirmMessage.addEventHandler("onclick",this.fn_confirmMessage,this);
        };
        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
