function checkPermission(login){
    var checkbox = document.getElementById('permission');
    if (checkbox.checked != false) {
    window.location.href = '/chat?command=show_admin_page?login=' + login;
    }
}
}