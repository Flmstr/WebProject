$(document).ready(function() {
  //Объявление сущностей БД
  var columnDefs = [{
    data: "id",
    title: "ID",
    type: "readonly",
    visible: false,
  },
  {
    data: "name",
    title: "Типы работ"
  }];

  var myTable;

  var url_ws_mock_get = '/api/typework';
  var url_ws_mock_ok = '/api/typework';
  // Файл локализации  /js/Russian.json
  myTable = $('#typework').DataTable({
    "language": {
                  "url": "/js/Russian.json"
              },
    "sPaginationType": "full_numbers",
    ajax: {
        url : url_ws_mock_get,
        // our data is an array of objects, in the root node instead of /data node, so we need 'dataSrc' parameter
        dataSrc : ''
    },
    columns: columnDefs,
	    dom: 'Bfrtip',        // Needs button container
        select: 'single',
        responsive: {details: false},
        altEditor: true,
        buttons: [{
            text: 'Добавить',
            name: 'add'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Редактировать',
            name: 'edit'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Удалить',
            name: 'delete'      // do not change name
        },
        {
            text: 'Перезагрузить',
            name: 'refresh'      // do not change name
        }],
        onAddRow: function(datatable, rowdata, success, error) {
            $.ajax({
                // a tipycal url would be / with type='PUT'
                url: url_ws_mock_ok + '/PUT',
                type: 'GET',
                data: rowdata,
                success: success,
                error: error
            });
        },
        onDeleteRow: function(datatable, rowdata, success, error) {
            $.ajax({
                // a tipycal url would be /{id} with type='DELETE'
                url: url_ws_mock_ok + '/DELETE/' + rowdata.id,
                type: 'GET',
                data: rowdata,
                success: success,
                error: error
            });
        },
        onEditRow: function(datatable, rowdata, success, error) {
            $.ajax({
                // a tipycal url would be /{id} with type='POST'
                url: url_ws_mock_ok + '/POST/' + rowdata.id,
                type: 'GET',
                data: rowdata,
                success: success,
                error: error
            });
        }
  });


});