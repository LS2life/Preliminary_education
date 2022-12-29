export const load = async ({ fetch }) => {
	const fetchProducts = async () => {
		const productRes = await fetch('https://dummyjson.com/products');
		const productData = await productRes.json();
		return productData.products;
	};

	const fetchUsers = async () => {
		const usersRes = await fetch('https://dummyjson.com/users?limit=10');
		const usersData = await usersRes.json();
		return usersData.users;
	};

	return {
		products: fetchProducts()
		// users: fetchUsers()
	};
};
