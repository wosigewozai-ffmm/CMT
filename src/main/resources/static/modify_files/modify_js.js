function modifyRelation(){
    var model = {
        "nameA": document.getElementById("relationModifyNameA").value,
        "relation": document.getElementById("relationModifyRelation").value,
        "nameB": document.getElementById("relationModifyNameB").value,
        "modifyType" : modify_type
    }
    $.ajax({
        url: "/modify/modifyRelation",
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

var modify_type;

function modifyNameAAvailable(){
    document.getElementById("relationModifyNameA").disabled = "";
    document.getElementById("relationModifyRelation").disabled = "disabled";
    document.getElementById("relationModifyNameB").disabled = "disabled";
    modify_type=1;
}

function modifyRelationAvailable(){
    document.getElementById("relationModifyNameA").disabled = "disabled";
    document.getElementById("relationModifyRelation").disabled = "";
    document.getElementById("relationModifyNameB").disabled = "disabled";
    modify_type=2;
}

function modifyNameBAvailable(){
    document.getElementById("relationModifyNameA").disabled = "disabled";
    document.getElementById("relationModifyRelation").disabled = "disabled";
    document.getElementById("relationModifyNameB").disabled = "";
}

function selectRelation(nameA, relation, nameB){
    document.getElementById("relationModifyNameA").value = nameA;
    document.getElementById("relationModifyRelation").value = relation;
    document.getElementById("relationModifyNameB").value = nameB;
    modify_type=3;
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
function deleteEntity(){
    var model = {
        "name": document.getElementById("deleteEntity").value,
    }
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

function addRelationChange(){
    $("#EntityA").find("option").remove();
    $("#EntityB").find("option").remove();
    switch (document.getElementById("addRelation").value) {
        case "主治":
            $("#EntityA").append("<option value='Value'>方剂</option>");
            $("#EntityB").append("<option value='Value'>症状</option>");
            break;
        case"组成":
            $("#EntityA").append("<option value='Value'>药材</option>");
            $("#EntityB").append("<option value='Value'>方剂</option>");
            break;
        case"具有":
            $("#EntityA").append("<option value='Value'>方剂</option>");
            $("#EntityB").append("<option value='Value'>功效</option>");
            break;
        case"属于":
            $("#EntityA").append("<option value='Value'>方剂</option>");
            $("#EntityB").append("<option value='Value'>功用大类</option>");
            $("#EntityB").append("<option value='Value'>功用小类</option>");
            break;
        case"包含":
            $("#EntityA").append("<option value='Value'>功用大类</option>");
            $("#EntityB").append("<option value='Value'>功用小类</option>");
            break;
    }
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
        success: function (data) {
            console.log(data)
            var result = data.result
            $("#message").html(result)
        },
        error: function (e) {
            alert("error,请输入正确参数");
        }
    })
}