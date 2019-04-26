$(document).ready(function(){
    $('#tb').yhhDataTable({
        'paginate':{
            'changeDisplayLen':true,
            'type':'updown',
            'visibleGo': true
        },
        'tbodyRow':{
            'zebra':true
        }
    });
    /*更新表格*/
    var refreshTable = function(data,page){
        if ($.isEmptyObject(data)) data = {};
        var toData = {
            'ajaxParam':{'data':data}
        }
        if (!$.isEmptyObject(page)){
            toData.paginate = {};
            toData.paginate.currentPage = page;
        }
        var $table = $page.find('.result-list');
        $table.yhhDataTable('refresh',toData);
    }
});