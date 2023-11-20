Vue.createApp({
     
     data() {
          return {
               charging: true,
               user: {},
               studentsList: [],
               professorsList: [],
               name: '',
               lastName: '',
               email: '',
               password: '',
          }
     },

     created(){

          axios.get(`/users/current`)
          .then(datos => {
               this.user = datos.data
               console.log(this.user)
          }),

          axios.get(`/students`)
          .then(datos => {
               this.studentsList = datos.data
               console.log(this.studentsList)
          }),

          axios.get('/professors')
          .then(datos => {
               this.professorsList = datos.data
               console.log(this.professorsList)
          }),

          setTimeout(() => { this.charging = false }, 2000)
     },

     methods:{

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
                         axios.post('/logout')
                         .then(window.location.href = '/index.html')
                    }
               })
               .catch( error => error.message + "Oops! something happened, you couldn't log out" )
          },

          addStudent(){
               let newStudent = {
                    name: this.name,
                    lastName: this.lastName,
                    email: this.email,
                    password: this.password
               }
               axios.post(`/students`, newStudent)
               .then(window.location.href = '/admin-panel.html')
          },

          deleteStudent(id){
               Swal.fire({
                    title: 'Do you confirm the request?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#1b1c1a',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Confirm!'
               })
               .then((result) => {
                    if (result.isConfirmed) {   
                         axios.delete(`/students/${id}`)
                         .then(window.location.href = '/admin-panel.html')
                    }
               })
               .catch( error => error.message + "Oops! something happened, you couldn't delete the student" )
          },

          editStudent(id){
               axios.patch(`/students/${id}`)
               .then(window.location.href = '/admin-panel.html')
          },

          addProfessor(){
               let newProfessor = {
                    name: this.name,
                    lastName: this.lastName,
                    email: this.email,
                    password: this.password
               }
               axios.post('/professors', newProfessor)
               .then(window.location.href = '/admin-panel.html')
          },
          
          deleteProfessor(id){
               Swal.fire({
                    title: 'Do you confirm the request?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#1b1c1a',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Confirm!'
               })
               .then((result) => {
                    if (result.isConfirmed) {   
                         axios.delete(`/professors/${id}`)
                         .then(window.location.href = '/admin-panel.html')
                    }
               })
               .catch( error => error.message + "Oops! something happened, you couldn't delete the professor" )
          },

          editProfessor(id){
               axios.patch(`/professors/${id}`)
               .then(window.location.href = '/admin-panel.html')
          }

     }, // Cierre de (methods)

}).mount('#app')

