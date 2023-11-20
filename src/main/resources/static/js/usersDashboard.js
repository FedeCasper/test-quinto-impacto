Vue.createApp({

     data() {
          return {
               charging: true,
               user: [],
               userCourses: [],
          }
     },

     created(){
          
          axios.get(`/users/current`)
               .then(datos => {
                    this.user = datos.data
                    console.log(this.user)
                    this.userCourses = this.user.userCoursesDto
                    console.log(this.userCourses);
               }),

          setTimeout(() => { this.charging = false }, 2000)
     },


     methods:{

          formatearFecha(fecha){
               let date = new Date (fecha)
               let year = date.getFullYear()  
               let day = date.getDay() 
               let array_year = Array.from(year.toString()).slice(-2).join("")
               let month = date.getMonth() +1
               if(month < 10){
                    month = "0" + month
               }
               let day_month_year = day + "/" + month + "/" + array_year
               return day_month_year
          },

          createAccount(){
               axios.post('/api/clients/current/accounts')
                    .then(response =>
                         location.reload(),
                         console.log('The account was created successfully!!!'))
                    .catch( error => error.message + "The account could not be created")
               },

          logout(){
               Swal.fire({
                    title: 'Do you want to leave the site?',
                    text: "This will close your session",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#1b1c1a',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Confirm!'
               })
               .then((result) => {
                    if (result.isConfirmed) {   
                         axios.post('/api/logout')
                         .then(window.location.href = '/web/index.html')
                    }
               })
               .catch( error => error.message + "Oops! something happened, you couldn't log out" )
          },

     }, // Cierre de (methods)

     }).mount('#app')