/*Validate for Login and Signup form input */
function validateForm() {
	let x = document.forms["myForm"]["username"].value;
	let y = document.forms["myForm"]["password"].value;
	if ((x == "") || (y == "")) {
		alert("Vui lòng nhập user và password.");
		return false;
	}
}
/* Make plus and minus quantity button */
var cart = document.querySelector('.cart-totals');

cart.addEventListener('click', function(ev) {
	var tgt = ev.target;
	if (tgt.matches('input[type="button"]')) {

		var input = document.getElementById(tgt.dataset.for);
		var currentValue = +input.value;
		var minValue = +input.min;


		if (tgt.value === '+') {
			input.value = currentValue + 1;
		}
		else if (currentValue > minValue) {
			input.value = currentValue - 1;
		}

	}
});
/*Set Style  */
/* Select production by Brand: category__heading */
var brands = document.getElementsByClassName('category-item');
for (var i =0; i<brands.length;i++) {
	brands[i].addEventListener('click',function(){
		var current = document.getElementsByClassName('category-item--active');
		current[0].classList.remove('category-item--active');
		this.classList.add('category-item--active');
		alert('anh yeu em');
	})
};

