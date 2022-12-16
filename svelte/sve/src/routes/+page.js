// since there's no dynamic data here, we can prerender
// it so that it gets served as a static asset in production
// export const prerender = true;

export const load = async ({ fetch }) => {

    const fetchProducts = async () => {
        const productRes = await fetch('https://dummyjson.com/products?limit=10')
        const productData = await productRes.json()
        return productData.products

    }

    const fetchUsers = async () => {
        const usersRes = await fetch('https://dummyjson.com/users?limit=10')
        const usersData = await usersRes.json()
        return usersData.users
    }

    const fetchBoard = async () => {
        const boardRes = await fetch('http://localhost:3306/dbplayground')
        const boardData = await boardRes.json()
        return boardData
    }

    return {
        products: fetchProducts(),
        users: fetchUsers(),
        board: fetchBoard()
    }
}
