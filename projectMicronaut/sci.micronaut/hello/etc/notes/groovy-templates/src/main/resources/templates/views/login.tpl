package templates.views
html {
    head {
        title('This is My Template')
    }
}
body {
    img( src: "/images/loginIcon.jpg" , alt: "login icon")
    h3 "This is My Template: login"
    form( name:'f', action:'/postExample' , method:'POST') {
        br()
        input ( name:'username', type:'text', placeholder: "User ID", value: user.username )
        br()
        br()
        input ( name:'password', type:'password', placeholder: "Password", value: user.password )
        input ( name:'grant_type', type:'hidden', placeholder: "grant_type", value: "password" )
        input ( name:'scope', type:'hidden', placeholder: "scope", value: "read" )
        div (class:'form-actions') {
            input (type:'submit', value:'Login')
        }
    }
}