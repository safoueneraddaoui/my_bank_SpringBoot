function deleteClient(cin){

		swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
		    $.ajax({
		type: "GET",
		url: "/client/delete-ajax",
		data: { 'cin': cin },
		success: function() {
		$('#'+cin).remove();
			swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    });
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.responseText);
		}
	});

		  } else {
		    swal("Your imaginary file is safe!");
		  }
		});

	}