var pForm = nexacro.Form.prototype;

/*
 ===============================================================================
 ==  Dataset 관련 공통 함수
 ===============================================================================
 ● this.gfn_dataSetChange				: dataSet 데이터 변경여부 체크 함수
 ● this.gfn_transaction					: DataSet 데이터를 갱신하기 위한 서비스를 호출하는 트랜잭션 함수
 ● this.gfn_getGridColumnIndex 			: 그리드 특정 컬럼의 인덱스 찾기는 함수
 ● this.gfn_getGridHeaderText 			: 그리드 컬럼 인덱스를 기준으로 헤더 텍스트 찾는 함수
 ● this.gfn_checkRequired 				: 그리드의 필수항목 체크하는 함수
 */


/**
 * @description		dataSet 데이터 변경여부 체크
 * @param 			{objDs			: nexacro.NormalDataset} 	데이터셋
 * @return 			{bDsChange		: boolen} 					true, false
 */  
pForm.gfn_dataSetChange = function(objDs)
{
	var bDsChange = false;
	
	var nCnt = objDs.rowcount;	
	for(var i=0; i<nCnt; i++) {
		var nRowType = objDs.getRowType(i);
		/*
		Dataset.ROWTYPE_EMPTY		0		존재하지 않는 행의 상태	
		Dataset.ROWTYPE_NORMAL		1		초기 행의 상태
		Dataset.ROWTYPE_INSERT		2		추가된 행의 상태
		Dataset.ROWTYPE_UPDATE		4		수정된 행의 상태
		Dataset.ROWTYPE_DELETE		8		삭제된 행의 상태
		Dataset.ROWTYPE_GROUP		16		그룹 정보 행의 상태
		*/
		if (nRowType == Dataset.ROWTYPE_INSERT || nRowType == Dataset.ROWTYPE_UPDATE || nRowType == Dataset.ROWTYPE_DELETE) {
			bDsChange = true;
			break;
		}
	}
	
	var nDelCnt = objDs.getDeletedRowCount();
	for (var i=0; i<nDelCnt; i++) {
		bDsChange = true;
		break;
	}
	
	return bDsChange;
};


/**
 * @description		DataSet 데이터를 갱신하기 위한 서비스를 호출하는 트랜잭션 함수
 * @param 			{sSvcID			: String}	서비스ID 명칭
 * @param  			{sSvcURL		: String} 	controller 호출하기 위한 서비스 URL
 * @param  			{sInDataSets	: String} 	input 데이터셋 (input=ds_codeType)
 * @param  			{sOutDataSets	: String} 	output 데이터셋 (ds_codeType=output)
 * @param  			{sCallbackFunc	: String} 	call back function 명칭
 * @param  			{bAsync			: Boolean} 	true(비동기), false(동기)
 * @param  			{nDataType		: Number} 	서버로 데이터 전송 형식 (XML-0, binary-1, SSV-2, JSON-2)
 * @param  			{bCompress		: Boolean} 	true(압축), false(압축X)
 * @param  			{String} 
 */  
pForm.gfn_transaction = function(sSvcID, sSvcURL, sInDataSets, sOutDataSets, sArgument, sCallbackFunc, bAsync, nDataType, bCompress)
{	
	if(pForm.gfn_isNull(bAsync)) bAsync = true;
	if(pForm.gfn_isNull(nDataType)) nDataType = 0;
	if(pForm.gfn_isNull(bCompress)) bCompress = false;
	if(pForm.gfn_isNull(sCallbackFunc)) sCallbackFunc = "gfn_callback";
	this.transaction(sSvcID, sSvcURL, sInDataSets, sOutDataSets, sArgument, sCallbackFunc, bAsync, nDataType, bCompress);
};


pForm.gfn_callback = function(sServiceID, nErrorCode, sErrorMessage)
{
	if(nErrorCode < 0) {
		alert("공통에서 발생 오류 : " + sErrorMessage);
		return;
	}
};

/**
 * @description		그리드 특정 컬럼의 인덱스 찾기는 함수
 * @param 			{objGrid		: Object}	그리드(this.grd_codeType)
 * @param 			{sColumnName	: String}	그리드에 바인드된 컬럼명 (CODE_TYPE_NM)
 * @return 			{i				: Number} 	그리드에서 조회된 컬럼의 위치(0,1,2...n)
 */  
pForm.gfn_getGridColumnIndex = function(objGrid, sColumnName)
{
	//그리드 전체 컬럼의 갯수
    var nColumnCount = objGrid.getCellCount("body");
	
    for (var i=0; i<nColumnCount; i++) {
        //그리드 프로퍼티의 바인드된 text 값 추출
		var sBindColumnName = objGrid.getCellProperty("body", i, "text");

		//바인드된 컬럼의 명칭이 동일할 경우 찾은 인덱스 리턴
        if (sBindColumnName == ("bind:" + sColumnName)) return i;
    }
    return -1;
};

/**
 * @description		그리드 컬럼 인덱스를 기준으로 헤더 텍스트 찾는 함수
 * @param 			{objGrid		: Object}	그리드(this.grd_codeType)
 * @param 			{nColumnIndex	: Number}	그리드에 컬럼의 인덱스(0,1,2...n)
 * @return 			{sHeaderText	: String} 	그리드 컬럼의 헤더 텍스트(코드유형명)
 */  
pForm.gfn_getGridHeaderText = function(objGrid, nColumnIndex)
{
    if (nColumnIndex<0) return "";
	
	//그리드 헤더 텍스트 추출
    var sHeaderText = objGrid.getCellText(-1, nColumnIndex);

    // 줄바꿈 제거
    sHeaderText = sHeaderText.replace(/\r/g, "");
    sHeaderText = sHeaderText.replace(/\n/g, " ");

    return sHeaderText;
};

/** 
 * @description		그리드의 필수항목 체크하는 함수 
 * @param 			{objGrid		: Object}	그리드(this.grd_codeType)
 * @param 			{arrRequired	: Arrary}	필수체크항목 배열(["CODE_TYPE", "CODE_TYPE_NM"]
 * @return 			{bDsChange		: boolen} 	true(정상), false(오류)
 */
pForm.gfn_checkRequired = function(objGrid, arrRequired)
{
    var app   = nexacro.getApplication();
    var objDs = objGrid.getBindDataset();

	//그리드에 바인드된 데이터셋이 없으면 리턴
    if (!objDs) return true;

	//찾은 바인드셋의 데이터 건수
    var nRowCnt = objDs.rowcount;

	//데이터셋 데이터 건수 기준으로 필수항목 체크
    for (var nRow=0; nRow<nRowCnt; nRow++) {
	
        //데이터셋 상태가 : 초기 데이터는 Skip
        if (objDs.getRowType(nRow) == Dataset.ROWTYPE_NORMAL) continue;
		
		//매개변수의 필수항목 만큼 체크
        for (var i=0; i<arrRequired.length; i++) {
            var sColumnName  = arrRequired[i];
			var sColumnValue = objDs.getColumn(nRow, sColumnName);
			
            if (pForm.gfn_isNull(sColumnValue)) {
                var nColIndex   = this.gfn_getGridColumnIndex(objGrid, sColumnName);
                var sHeaderText = this.gfn_getGridHeaderText(objGrid, nColIndex);

                this.gfn_msgBox("MSG-A-10010", app.languageCd, [sHeaderText]); //{1} 항목은 필수입니다.

                //오류 발생 위치로 이동
				if (nColIndex>=0) {
                    objGrid.setFocus();
                    objGrid.selectCell(nRow, nColIndex);
                }
                return false;
            }
        }
    }
    return true;
};