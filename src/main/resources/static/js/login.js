
const { createApp } = Vue

createApp({
     
     data() {
          return {
               email:'',
               password:'',
               error:'',
               name: '',
               lastName: '',
               userRol:[],
          }
     },

     created(){

     },

     methods:{

          register(){
               let newUser = {
                    name: this.name,
                    lastName: this.lastName,
                    email: this.email,
                    password: this.password,
                    userRol: this.userRol
               }
               if(this.name == 0 || this.lastName == 0 || this.email == 0 || this.password == 0 || this.userRol == 0){
                    Swal.fire({
                         icon: 'error',
                         title: 'Oops...',
                         text: 'There are incomplete fields!',
                    })
               }else if(this.password.length <= 4 || this.password.length >= 15){
                    Swal.fire({
                         icon: 'error',
                         title: 'Oops...',
                         text: 'The password is either to short or too long!',
                    })
               }else if(!this.email.includes("@") || !this.email.includes(".") ){
                    Swal.fire({
                         icon: 'error',
                         title: 'Oops...',
                         text: 'Please check the email!',
                    })
               }else{
                    console.log(newUser);
               axios.post('/users/user',newUser)
               .then(
                    Swal.fire({
                         position: 'center',
                         icon: 'success',
                         title: 'User created',
                         showConfirmButton: true,
                    })
               .then((result) => {
                    if (result.isConfirmed) {   
                         this.login()
                    }
               }))
               .then(response => 
                    console.log("Registered!"))
               .catch(function(error){
                    if (error.response.status === 403) {
                         Swal.fire({
                              icon: 'error',
                              title: 'Oops...',
                              text: 'There is already a user with that email!',
                         })
                         console.log('Error', error.message);
                    }else {
                         Swal.fire({
                              icon: 'error',
                              title: 'Oops...',
                              text: 'Something went wrong!',
                         })
                         console.log('Error', error.message);
                    }
               })
          }
          },

          login(){
                    axios.post('/login',`email=${this.email}&password=${this.password}`)
                    .then(() => {
                         console.log('signed in!!!')} 
                         )
                    .then(response => 
                         this.roleChecker()
                         )
                    .catch(error => {
                         window.alert(error.message)
                    }
               )
          },

          roleChecker(){
               axios.get('/users/current')
               .then((datos) => {
                    console.log(datos);
                    this.rol = datos.data.userRol
                    console.log(this.rol)
                    if(this.rol == 'STUDENT'){
                         window.location.href = '/usersDashboard.html'
                    }else if(this.role == 'ADMIN'){
                         window.location.href = '/admin-panel.html'
                    }
          })},

          show(){
               document.querySelector('.form-group span').addEventListener('click', e => {
                    const passwordInput = document.querySelector('#psw');
                    if (e.target.classList.contains('show')) {
                         e.target.classList.remove('show');
                         // e.target.textContent = 'Ocultar';
                         passwordInput.type = 'text';
                    } else {
                         e.target.classList.add('show');
                         // e.target.textContent = 'Mostrar';
                         passwordInput.type = 'password';
                    }
               })
          }

     },

}).mount('#app')

