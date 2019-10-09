var btn = document.getElementById("btnAllProducts");
btn.onclick = () => {

	/*
	 * fetch() returns a Promise object, which either gets
	 * resolved or gets rejected.
	 */
	var url = 'api/products';
	var options = {
		method: 'GET',
		headers: {
			'Accept': 'application/json'
		}
	};
	
	fetch(url, options)
		.then(resp => resp.json())
		.then(data => display(data))
		.catch(err => console.log(err));
	
};

/**
 * Displays the data as billeted list
 * @param data - An array of product objects
 * @returns
 */
function display(data) {
	var list = data.map(p=>'<li>'+p.description+'</li>').join('');
	document.getElementById("productList").innerHTML = list;
}







