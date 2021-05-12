var pos = new Array();
for(var i = 0; i < 999; i++) {
    pos[i] = new Array();
    for(var j = 0; j < 3; j++) {
        pos[i][j] = "";
    }
}
var schemaLength;
function initData(){
    document.getElementById("selectIntro_").style.backgroundColor="#25331e";
    document.getElementById("selectAdd_").style.backgroundColor="#405133";
    document.getElementById("selectDelete_").style.backgroundColor="#405133";
    document.getElementById("selectModify_").style.backgroundColor="#405133";
    document.getElementById("selectIntro_").style.color="#FFFF00";
    document.getElementById("selectAdd_").style.color="#FFFFFF";
    document.getElementById("selectDelete_").style.color="#FFFFFF";
    document.getElementById("selectModify_").style.color="#FFFFFF";
    var model={

    }
    $.ajax({
        url: "/modify/initData",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            schemaLength = data.data[0].schemaList.length;
            for (i = 0; i < data.data[0].schemaList.length; i++){
                pos[i][0]=data.data[0].schemaList[i][0];
                pos[i][1]=data.data[0].schemaList[i][1];
                pos[i][2]=data.data[0].schemaList[i][2];
            }
            for (i = 0; i < data.data[0].relationList.length; i++){
                document.getElementById("addRelation").options.add(new Option(data.data[0].relationList[i],data.data[0].relationList[i]));
                document.getElementById("excelRelationType").options.add(new Option(data.data[0].relationList[i],data.data[0].relationList[i]));
            }
            for (i = 0; i < data.data[0].entityList.length; i++){
                document.getElementById("entityType").options.add(new Option(data.data[0].entityList[i],data.data[0].entityList[i]));
                document.getElementById("modifyEntityType").options.add(new Option(data.data[0].entityList[i],data.data[0].entityList[i]));
            }
        }
    })
}

function selectDeleteRelation(nameA, relation, nameB){
    document.getElementById("deleteEntityA").value = nameA;
    document.getElementById("deleteRelation").value = relation;
    document.getElementById("deleteEntityB").value = nameB;
}


function delete_searchByRelation(){
    var model = {
        "relation": document.getElementById("delete_searchByRelationRelation").value,
    }
    $.ajax({
        url: "/modify/searchByRelation",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            document.getElementById("deleteTable").style.display = "";
            document.getElementById("entityTable").style.display = "none";
            $("#deleteTable tr:not(:first)").empty("");
            for (i = 0; i < data.data.length; i++)
            {
                var tr = $("<tr><td>" + data.data[i].nameA + "</td><td>" + data.data[i].relation + "</td><td>" + data.data[i].nameB + "</td><td><a href='#' onclick='selectDeleteRelation($(this).closest(\"tr\").find(\"td\").eq(0).text(),$(this).closest(\"tr\").find(\"td\").eq(1).text(),$(this).closest(\"tr\").find(\"td\").eq(2).text());'>select</a></td></tr>\")</tr>");
                $("#deleteTable").append(tr);
            }
        }
    })
}

function delete_searchByEntity(){
    var model={
        "name":document.getElementById("delete_searchByEntity").value,
    }
    $.ajax({
        url: "/modify/searchByEntity",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            document.getElementById("deleteTable").style.display = "";
            document.getElementById("entityTable").style.display = "none";
            $("#deleteTable tr:not(:first)").empty("");
            for (i = 0; i < data.data.length; i++)
            {
                var tr = $("<tr><td>" + data.data[i].nameA + "</td><td>" + data.data[i].relation + "</td><td>" + data.data[i].nameB + "</td><td><a href='#' onclick='selectDeleteRelation($(this).closest(\"tr\").find(\"td\").eq(0).text(),$(this).closest(\"tr\").find(\"td\").eq(1).text(),$(this).closest(\"tr\").find(\"td\").eq(2).text());'>select</a></td></tr>\")</tr>");
                $("#deleteTable").append(tr);
            }
        }
    })
}
function selectFunction(func){
    $("#deleteTable tr:not(:first)").empty("");
    $("#entityTable tr:not(:first)").empty("");
    switch (func){
        case "add":
            document.getElementById("modify_add").style.display = "";
            document.getElementById("modify_modify").style.display = "none";
            document.getElementById("modify_delete").style.display = "none";
            document.getElementById("modify_intro").style.display="none";
            document.getElementById("show_table").style.display="none";
            document.getElementById("selectAdd_").style.backgroundColor="#25331e";
            document.getElementById("selectIntro_").style.backgroundColor="#405133";
            document.getElementById("selectDelete_").style.backgroundColor="#405133";
            document.getElementById("selectModify_").style.backgroundColor="#405133";
            document.getElementById("selectAdd_").style.color="#FFFF00";
            document.getElementById("selectIntro_").style.color="#FFFFFF";
            document.getElementById("selectDelete_").style.color="#FFFFFF";
            document.getElementById("selectModify_").style.color="#FFFFFF";
            break;
        case "modify":
            document.getElementById("modify_add").style.display = "none";
            document.getElementById("modify_modify").style.display = "";
            document.getElementById("modify_delete").style.display = "none";
            document.getElementById("modify_intro").style.display="none";
            document.getElementById("show_table").style.display="";
            document.getElementById("selectModify_").style.backgroundColor="#25331e";
            document.getElementById("selectIntro_").style.backgroundColor="#405133";
            document.getElementById("selectDelete_").style.backgroundColor="#405133";
            document.getElementById("selectAdd_").style.backgroundColor="#405133";
            document.getElementById("selectModify_").style.color="#FFFF00";
            document.getElementById("selectIntro_").style.color="#FFFFFF";
            document.getElementById("selectDelete_").style.color="#FFFFFF";
            document.getElementById("selectAdd_").style.color="#FFFFFF";
            break;
        case "delete":
            document.getElementById("modify_add").style.display = "none";
            document.getElementById("modify_modify").style.display = "none";
            document.getElementById("modify_delete").style.display = "";
            document.getElementById("modify_intro").style.display="none";
            document.getElementById("show_table").style.display="";
            document.getElementById("selectDelete_").style.backgroundColor="#25331e";
            document.getElementById("selectIntro_").style.backgroundColor="#405133";
            document.getElementById("selectAdd_").style.backgroundColor="#405133";
            document.getElementById("selectModify_").style.backgroundColor="#405133";
            document.getElementById("selectDelete_").style.color="#FFFF00";
            document.getElementById("selectIntro_").style.color="#FFFFFF";
            document.getElementById("selectAdd_").style.color="#FFFFFF";
            document.getElementById("selectModify_").style.color="#FFFFFF";
            break;
        case "intro":
            document.getElementById("modify_add").style.display = "none";
            document.getElementById("modify_modify").style.display = "none";
            document.getElementById("modify_delete").style.display = "none";
            document.getElementById("modify_intro").style.display="";
            document.getElementById("show_table").style.display="none";
            document.getElementById("selectIntro_").style.backgroundColor="#25331e";
            document.getElementById("selectAdd_").style.backgroundColor="#405133";
            document.getElementById("selectDelete_").style.backgroundColor="#405133";
            document.getElementById("selectModify_").style.backgroundColor="#405133";
            document.getElementById("selectIntro_").style.color="#FFFF00";
            document.getElementById("selectAdd_").style.color="#FFFFFF";
            document.getElementById("selectDelete_").style.color="#FFFFFF";
            document.getElementById("selectModify_").style.color="#FFFFFF";
            break;
    }
}

function strength(strenthB){
    var model ={
        "nameA":"麻黄汤",
        "nameB":strenthB,
        "relation": "ties"
    }
    $.ajax({
        url: "/modify/entityStrength",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function addExcelRelation(){
    var model = {
        "name" : document.getElementById("filename").value,
        "relation":document.getElementById("excelRelationType").value,
    }
    $.ajax({
        url: "/modify/addExcelRelation",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function addExcelEntity(){
    var model = {
        "name" : document.getElementById("filename").value,
    }
    $.ajax({
        url: "/modify/addExcelEntity",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function searchByRelation(){
    var model = {
        "relation": document.getElementById("searchByRelationRelation").value,
    }
    $.ajax({
        url: "/modify/searchByRelation",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            document.getElementById("entityTable").style.display = "";
            document.getElementById("deleteTable").style.display = "none";
            $("#entityTable tr:not(:first)").empty("");
            for (i = 0; i < data.data.length; i++)
            {
                var tr = $("<tr><td>" + data.data[i].nameA + "</td><td>" + data.data[i].relation + "</td><td>" + data.data[i].nameB + "</td><td><a href='#' onclick='selectRelation($(this).closest(\"tr\").find(\"td\").eq(0).text(),$(this).closest(\"tr\").find(\"td\").eq(1).text(),$(this).closest(\"tr\").find(\"td\").eq(2).text());'>select</a></td></tr>\")</tr>");
                $("#entityTable").append(tr);
            }
        }
    })
}

var modifyRelationModel= {
    "nameA_old": "",
    "relation_old": "",
    "nameB_old": "",
    "nameA": "",
    "relation": "",
    "nameB":"",
    "modifyType" : ""
}

function modifyRelation(){
    modifyRelationModel.nameA = document.getElementById("relationModifyNameA").value;
    modifyRelationModel.relation = document.getElementById("relationModifyRelation").value;
    modifyRelationModel.nameB = document.getElementById("relationModifyNameB").value;

    $.ajax({
        url: "/modify/modifyRelation",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(modifyRelationModel), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function modifyNameAAvailable(){
    document.getElementById("relationModifyNameA").disabled = "";
    document.getElementById("relationModifyRelation").disabled = "disabled";
    document.getElementById("relationModifyNameB").disabled = "disabled";
    document.getElementById("relationModifyRelation").value = modifyRelationModel.relation_old;
    document.getElementById("relationModifyNameB").value = modifyRelationModel.nameB_old;
    modifyRelationModel.modifyType=1;
}

function modifyRelationAvailable(){
    document.getElementById("relationModifyNameA").disabled = "disabled";
    document.getElementById("relationModifyRelation").disabled = "";
    document.getElementById("relationModifyNameB").disabled = "disabled";
    document.getElementById("relationModifyNameA").value = modifyRelationModel.nameA_old;
    document.getElementById("relationModifyNameB").value = modifyRelationModel.nameB_old;
    modifyRelationModel.modifyType=2;
}

function modifyNameBAvailable(){
    document.getElementById("relationModifyNameA").disabled = "disabled";
    document.getElementById("relationModifyRelation").disabled = "disabled";
    document.getElementById("relationModifyNameB").disabled = "";
    document.getElementById("relationModifyRelation").value = modifyRelationModel.relation_old;
    document.getElementById("relationModifyNameA").value = modifyRelationModel.nameA_old;
    modifyRelationModel.modifyType  =3;
}

function selectRelation(nameA, relation, nameB){
    modifyRelationModel.nameA_old=nameA;
    modifyRelationModel.relation_old=relation;
    modifyRelationModel.nameB_old=nameB;
    document.getElementById("relationModifyNameA").value = nameA;
    document.getElementById("relationModifyRelation").value = relation;
    document.getElementById("relationModifyNameB").value = nameB;
}

function searchByEntity(){
    var model={
        "name":document.getElementById("_searchByEntity").value,
    }
    $.ajax({
        url: "/modify/searchByEntity",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            document.getElementById("entityTable").style.display = "";
            document.getElementById("deleteTable").style.display = "none";
            $("#entityTable tr:not(:first)").empty("");
            for (i = 0; i < data.data.length; i++)
            {
                var tr = $("<tr><td>" + data.data[i].nameA + "</td><td>" + data.data[i].relation + "</td><td>" + data.data[i].nameB + "</td><td><a href='#' onclick='selectRelation($(this).closest(\"tr\").find(\"td\").eq(0).text(),$(this).closest(\"tr\").find(\"td\").eq(1).text(),$(this).closest(\"tr\").find(\"td\").eq(2).text());'>select</a></td></tr>\")</tr>");
                $("#entityTable").append(tr);
            }
        }
    })
}

function modifyEntity(){
    var model={
        "name":document.getElementById("entityName_get").value,
        "type":document.getElementById("modifyEntityType").value
    }
    $.ajax({
        url: "/modify/modifyEntity",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function searchModifyEntity(){
    var model={
        "name":document.getElementById("entityName_modify").value
    }
    $.ajax({
        url: "/modify/searchModifyEntity",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            document.getElementById("entityName_get").value = data.data[0].name;
            document.getElementById("modifyEntityType").value = data.data[0].type;
        }
    })

}
function deleteRelation(){
    var model = {
        "nameA": document.getElementById("deleteEntityA").value,
        "nameB": document.getElementById("deleteEntityB").value,
        "relation": document.getElementById("deleteRelation").value
    }
    if (confirm("确认删除“"+model.nameA+model.relation+model.nameB+"”这条关系")) {
        $.ajax({
            url: "/modify/deleteRelation",
            type: "POST",
            async: true,
            contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
            data: JSON.stringify(model), //将JSON对象转换为JSON字符串
            dataType: 'json',
            success: function (data) {
                alert(data.msg);
            }
        })
    }
}
function deleteEntity(){
    var model = {
        "name": document.getElementById("deleteEntity").value,
    }
    if (confirm("确认删除“"+model.name+"”实体相关的内容")) {
        $.ajax({
            url: "/modify/deleteEntity",
            type: "POST",
            async: true,
            contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
            data: JSON.stringify(model), //将JSON对象转换为JSON字符串
            dataType: 'json',
            success: function (data) {
                alert(data.msg);
            }
        })
    }
}

function addRelationChange(){
    $("#EntityA").find("option").remove();
    $("#EntityB").find("option").remove();
    for (i = 0; i < schemaLength; i++){
        if (pos[i][1] == document.getElementById("addRelation").value){
            $("#EntityA").append("<option value="+pos[i][0]+">"+pos[i][0]+"</option>");
            $("#EntityB").append("<option value="+pos[i][2]+">"+pos[i][2]+"</option>");
        }
    }
    // switch (document.getElementById("addRelation").value) {
    //     case "主治":
    //         $("#EntityA").append("<option value='Value'>方剂</option>");
    //         $("#EntityB").append("<option value='Value'>症状</option>");
    //         break;
    //     case"组成":
    //         $("#EntityA").append("<option value='Value'>药材</option>");
    //         $("#EntityB").append("<option value='Value'>方剂</option>");
    //         break;
    //     case"具有":
    //         $("#EntityA").append("<option value='Value'>方剂</option>");
    //         $("#EntityB").append("<option value='Value'>功效</option>");
    //         break;
    //     case"属于":
    //         $("#EntityA").append("<option value='Value'>方剂</option>");
    //         $("#EntityB").append("<option value='Value'>功用大类</option>");
    //         $("#EntityB").append("<option value='Value'>功用小类</option>");
    //         break;
    //     case"包含":
    //         $("#EntityA").append("<option value='Value'>功用大类</option>");
    //         $("#EntityB").append("<option value='Value'>功用小类</option>");
    //         break;
    // }
}
function insertRelation(){
    var model = {
        "nameA": document.getElementById("addEntityA").value,
        "nameB": document.getElementById("addEntityB").value,
        "relation": document.getElementById("addRelation").value
    }
    $.ajax({
        url:"/modify/addRelation",
        type:"POST",
        async:true,
        contentType:"application/json;charset=UTF-8",
        data: JSON.stringify(model),
        dataType:'json',
        success: function(data){
            alert(data.msg);
        }
    })
}
function selectChange(){
    document.getElementById("entityEffect").value="";
    document.getElementById("entityPrescription").value="";
    document.getElementById("entityHerb").value="";
    document.getElementById("entitySymptom").value="";
    document.getElementById("entityFunction_Large").value="";
    document.getElementById("entityFunction_Small").value="";
    switch (document.getElementById("entityType").value) {
        case "方剂":
            document.getElementById("entityEffect").disabled="";
            document.getElementById("entityPrescription").disabled="disabled";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="";
            document.getElementById("entityFunction_Large").disabled="";
            document.getElementById("entityFunction_Small").disabled="";
            break;
        case "功效":
            document.getElementById("entityEffect").disabled="disabled";
            document.getElementById("entityPrescription").disabled="disabled";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="disabled";
            document.getElementById("entityFunction_Large").disabled="disabled";
            document.getElementById("entityFunction_Small").disabled="disabled";
            break;
        case "药材":
            document.getElementById("entityEffect").disabled="disabled";
            document.getElementById("entityPrescription").disabled="";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="disabled";
            document.getElementById("entityFunction_Large").disabled="disabled";
            document.getElementById("entityFunction_Small").disabled="disabled";
            break;
        case "症状":
            document.getElementById("entityEffect").disabled="disabled";
            document.getElementById("entityPrescription").disabled="disabled";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="disabled";
            document.getElementById("entityFunction_Large").disabled="disabled";
            document.getElementById("entityFunction_Small").disabled="disabled";
            break;
        case "功用大类":
            document.getElementById("entityEffect").disabled="disabled";
            document.getElementById("entityPrescription").disabled="disabled";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="disabled";
            document.getElementById("entityFunction_Large").disabled="disabled";
            document.getElementById("entityFunction_Small").disabled="";
            break;
        case "功用小类":
            document.getElementById("entityEffect").disabled="disabled";
            document.getElementById("entityPrescription").disabled="disabled";
            document.getElementById("entityHerb").disabled="disabled";
            document.getElementById("entitySymptom").disabled="disabled";
            document.getElementById("entityFunction_Large").disabled="disabled";
            document.getElementById("entityFunction_Small").disabled="disabled";
            break;
    }
}
function addEntity() {
    var model = {
        "name": document.getElementById("entityName").value,
        "type": document.getElementById("entityType").value,
        "effect": document.getElementById("entityEffect").value,
        "prescription": document.getElementById("entityPrescription").value,
        "herb": document.getElementById("entityHerb").value,
        "symptom": document.getElementById("entitySymptom").value,
        "function_large": document.getElementById("entityFunction_Large").value,
        "function_small": document.getElementById("entityFunction_Small").value
    }
    $.ajax({
        url: "/modify/add",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function addHasEffect(){
    var model = {
        "nameA": document.getElementById("prescriptionName_hasEffect").value,
        "nameB": document.getElementById("effectName_hasEffect").value,
        "relation": "hasEffect"
    }
    $.ajax({
        url:"/modify/addRelation",
        type:"POST",
        async:true,
        contentType:"application/json;charset=UTF-8",
        data: JSON.stringify(model),
        dataType:'json',
        success: function(data){
            alert(data.msg);
        }
    })
}
function addEffect() {
    var model = {
        "name": document.getElementById("effectName").value,
        "type": "effect"
    }
    $.ajax({
        url: "/modify/add",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function addPrescription() {
    var model = {
        "name": document.getElementById("prescriptionName").value,
        "type": "prescription"
    }
    $.ajax({
        url: "/modify/add",
        type: "POST",
        async: true,
        contentType: "application/json;charset=UTF-8", //使用 application/json;charset=UTF-8
        data: JSON.stringify(model), //将JSON对象转换为JSON字符串
        dataType: 'json',
        success: function (data) {
            alert(data.msg);
        }
    })
}

function imgUpload(){
    var formdata=new FormData();
    formdata.append('fileName', $('#filename').get(0).files[0]);

    //ajax上传
    $.ajax({
        async: false,
        type: 'POST',
        url: "/modify/addExcel",
        dataType: 'text',
        data: formdata,
        contentType:false,//ajax上传图片需要添加
        processData:false,//ajax上传图片需要添加
        success: function(data){
            alert("success");
        }
    })
}