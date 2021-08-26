$(document).ready(function() {
  //Объявление сущностей БД
  var columnDefs = [{
    data: "id",
    title: "ID",
    type: "readonly",
    visible: false
  },
  {
    data: "idMonth",
    title: "Месяц"
  },
  {
    data: "company",
    title: "Организациия"
  },
  {
    data: "address",
    title: "Адрес"
  },
  {
    data: "nameObject",
    title: "Наименование"
  },
  {
    data: "quantity",
    title: "Количество"
  },
  {
    data: "price",
    title: "Цена"
    },
  {
    data: "sum",
    title: "Сумма"
  },
  {
    data: "discount",
    title: "Скидка"
  },
  {
    data: "endSum",
    title: "Конечная сумма"
  },
  {
    data: "typeWork",
    title: "Тип работы"
  },
  {
    data: "comment",
    title: "Комментарий"
  },
  {
    data: "name",
    title: "Сотрудник"
  }];

  var myTable;

  var url_ws_mock_get = '/api/inputdata';
  var url_ws_mock_ok = '/api/inputdata';
  // Файл локализации  /js/Russian.json
  myTable = $('#inputdata').DataTable({
    "language": {
                  "url": "/js/library/Russian.json"
              },
    "sPaginationType": "full_numbers",
    ajax:
    {
        url : url_ws_mock_get,
        // our data is an array of objects, in the root node instead of /data node, so we need 'dataSrc' parameter
        dataSrc : ''
    },
    columns: columnDefs,
	dom: 'Bfrtip',        // Needs button container
    select: 'single',
    responsive: {details: false},
    altEditor: true,
    buttons:
    [
//    {
//        text: 'Добавить',
//        name: 'add'        // do not change name
//    },
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