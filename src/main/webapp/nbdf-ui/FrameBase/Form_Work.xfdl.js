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
            obj._setContents({});
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
        this.addIncludeScript("Form_Work.xfdl","Lib::libDataSet.xjs");
        this.registerScript("Form_Work.xfdl", function() {
        this.executeIncludeScript("Lib::libDataSet.xjs"); /*include "Lib::libDataSet.xjs"*/;

        this.userId = "built1";

        this.fn_search = function(obj,e)
        {
        	this.ds_search.clearData();
        	var nRow = this.ds_search.addRow();
        	this.ds_search.setColumn(nRow, "CODE_TYPE"   , "CREATE_TYPE_CD");
        	this.ds_search.setColumn(nRow, "CODE_TYPE_NM", "생성");

        	var sSvcID 			= "selectCodeList";
        	var sSvcURL			= "svcUrl::com/COM10000M/selectCodeList.do";
        	var sInDatasets 	= "inSearchMap=ds_search";
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

        	var sSvcID 			= "saveCodeData";
        	var sSvcURL			= "svcUrl::com/COM10000M/saveCodeData.do";
        	var sInDatasets 	= "inCodeTypeList=ds_codeType:U";
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
        };
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.btn_search.addEventHandler("onclick",this.fn_search,this);
            this.btn_delete.addEventHandler("onclick",this.fn_delete,this);
            this.btn_save.addEventHandler("onclick",this.fn_save,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
        };
        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
