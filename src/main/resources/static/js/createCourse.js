Vue.createApp({

     data() {
          return {
          user: [],
          charging: true,
          avaiableCourses: [],
          userCourses: [],
          courseSelected: "",
          shiftSelected: ""
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

          axios.get(`/courses`)
          .then(datos => {
               this.avaiableCourses = datos.data
               console.log(this.avaiableCourses)
          }),

          setTimeout(() => { this.charging = false }, 2000)
     },


     methods:{

          createCourse(){
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
                    let newCourse = {
                         courseName: this.courseSelected,
                         courseShift: this.shiftSelected
                    }
                    if (result.isConfirmed) {   
                         axios.post('students/user_course', newCourse)
                         Swal.fire(
                         'Course Requested!',
                         'Your new card is available un cards section',
                         'success'
                         )
                         .then(setTimeout('document.location.reload()',3000))
                    }
               })
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

     },

}).mount('#app')