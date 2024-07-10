

const signup = async (e) => {
    const username = e.target.parentElement.children[2].value
    const password = e.target.parentElement.children[4].value
    const date = new Date()
    fetch('http://localhost:10000/api/user/signup', {
        method: 'post',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(
            {
                username,
                password,
                dateOfBirth: date
            }
        )
    }).then(res => {
        console.log(res)
        res.json().then(data => {
            localStorage.setItem('token', data.token)
            console.log(data)
            alert('register successful!')
        }).catch(err => console.log(err))
    }).catch(err => console.log(err))
}

document.getElementById('signup').addEventListener('click', signup)

const signin = async (e) => {
    const username = e.target.parentElement.children[2].value
    const password = e.target.parentElement.children[4].value
    fetch('http://localhost:10000/api/user/signin', {
        method: 'post',
        headers: {
            'content-type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
        body: JSON.stringify(
            {
                username,
                password,
            }
        )
    }).then(res => {
        console.log(res)
        res.json().then(data => {
            localStorage.setItem('token', data.token)
            console.log(data)
            alert('login successful!')
        }).catch(err => console.log(err))
    }).catch(err => console.log(err))
}

document.getElementById('signin').addEventListener('click', signin)