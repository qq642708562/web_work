var pageSize = null;
var pageNumber = null;
var pageCount = null;
function ajaxrequest(){
    pageSize = $('#pageSize').val();
    pageNumber = $('#pageNumber').text();
    var queryParams={
        productCode:$('#productCode').val(),
        barCode:$('#barCode').val(),
        company:$('#company').val()
    };
    var pageParams = {
        pageSize:pageSize,
        pageNumber:pageNumber,
        productCode:'productCode',
        desc:'mid(productCode,8,20) +1'
    };
    var data = {
        queryParams:JSON.stringify(queryParams),
        pageParams:JSON.stringify(pageParams)
    };
    $.ajax({
        type: "post",
        url: "queryProduct.do",
        data: data,
        dataType: "json",
        success: function (response) {
            var rows = response.rows;
            var total = response.total;
            pageCount = (Math.ceil(total/pageSize));
            $('#total').text(total);
            $('#pageCount').text(pageCount);
            $('tbody').empty();
            $.each(rows,function(index,row){
                var s = JSON.stringify(row);
                var str = "<tr data='"+s+"'>";
                str = str+'<td><input type="checkbox" value='+row.productCode+'></td>';
                str = str+'<td>'+row.productCode+'</td>';
                str = str+'<td>'+row.barCode+'</td>';
                str = str+'<td>'+row.tradeName+'</td>';
                str = str+'<td>'+row.primaryClassification+'</td>';
                str = str+'<td>'+row.secondaryClassification+'</td>';
                str = str+'<td>'+row.supplyPrice+'</td>';
                str = str+'<td>'+row.minPrice+'</td>';
                str = str+'<td>'+row.recommendedPrice+'</td>';
                str = str+'<td>'+row.commoditySpecifications+'</td>';
                str = str+'<td>'+row.commodityOrigin+'</td>';
                str = str+'<td>'+row.unitOfMeasurement+'</td>';
                str = str+'<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+row.commodityProvider+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>';
                str = str+'<td>'+row.auditStatus+'</td>';
                str = str+'</tr>';
                $("tbody").append(str);
            });
        },
        error: function () {
            alert("error");
        }
    });
}

function clean(){
    $('#productCode').val('');
    $('#barCode').val('');
    $('#company').val('');
}

function back(){
    if(pageNumber<=1){
        alert("This is the first page!");
    }else{
        $('#pageNumber').text(parseInt($('#pageNumber').text())-1);
        ajaxrequest();
    }
}

function next(){ 
    if(pageNumber>=pageCount){
        alert("This is the last page!");
    }else{
        $('#pageNumber').text(parseInt($('#pageNumber').text())+1);
        ajaxrequest();
    }
}

$(document).ready(function(){
    ajaxrequest();
    $('#checkbox').change(function(){
        if($('#checkbox').prop('checked')){
            $('tbody tr input:checkbox').attr("checked",true);
        }else{
            $('tbody tr input:checkbox').attr("checked",false);
        }
    });
    $('.page-item').click(function(){
        $('.page-item').removeClass('active');
        $(this).addClass('active');
    })
    $('#btnsearch').click(function(){
        ajaxrequest();
    });
    $('#btnclean').click(function(){
        clean();
    });
    $('#pageSize').change(function(){
        ajaxrequest();
    });
    $('#back').click(function(){
        back();
    });
    $('#next').click(function(){
        next();
    });
    $('#one').click(function(){
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
    $('#two').click(function(){
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
    $('#three').click(function(){
        pageNumber=3;
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
    $('#four').click(function(){
        pageNumber=4;
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
    $('#five').click(function(){
        pageNumber=5;
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
    $('#ten').click(function(){
        pageNumber=10;
        $('#pageNumber').text($(this).text());
        ajaxrequest();
    })
});