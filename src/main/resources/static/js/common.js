// 通用JS功能

// 页面加载完成后执行
$(document).ready(function() {
    // 初始化日期选择器
    initDatePickers();
    
    // 初始化表单验证
    initFormValidation();
    
    // 初始化弹窗
    initModals();
});

// 初始化日期选择器
function initDatePickers() {
    // 为所有日期输入框添加日期选择功能
    $('input[type="date"]').each(function() {
        // 设置默认值为今天
        if (!$(this).val()) {
            var today = new Date();
            var yyyy = today.getFullYear();
            var mm = String(today.getMonth() + 1).padStart(2, '0');
            var dd = String(today.getDate()).padStart(2, '0');
            var formattedDate = yyyy + '-' + mm + '-' + dd;
            $(this).val(formattedDate);
        }
    });
}

// 初始化表单验证
function initFormValidation() {
    // 为所有表单添加提交验证
    $('form').submit(function(e) {
        var isValid = true;
        var errorMessages = [];
        
        // 验证必填字段
        $(this).find('input[required], select[required], textarea[required]').each(function() {
            if (!$(this).val()) {
                isValid = false;
                var label = $(this).prev('label').text();
                errorMessages.push(label + '不能为空');
            }
        });
        
        // 显示错误信息
        if (!isValid) {
            e.preventDefault();
            alert(errorMessages.join('\n'));
        }
    });
}

// 初始化弹窗
function initModals() {
    // 为所有删除按钮添加确认弹窗
    $('a[data-toggle="confirm"]').click(function(e) {
        if (!confirm('确定要执行此操作吗？')) {
            e.preventDefault();
        }
    });
}

// 显示消息提示
function showMessage(message, type) {
    var alertClass = 'alert-info';
    if (type === 'error') {
        alertClass = 'alert-danger';
    } else if (type === 'success') {
        alertClass = 'alert-success';
    } else if (type === 'warning') {
        alertClass = 'alert-warning';
    }
    
    var alertHtml = '<div class="alert ' + alertClass + ' alert-dismissible fade show" role="alert">' +
        message +
        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
        '</div>';
    
    $('body').prepend(alertHtml);
    
    // 3秒后自动关闭
    setTimeout(function() {
        $('.alert').alert('close');
    }, 3000);
}

// 异步请求函数
function ajaxRequest(url, method, data, successCallback, errorCallback) {
    $.ajax({
        url: url,
        method: method,
        data: data,
        success: function(response) {
            if (successCallback) {
                successCallback(response);
            }
        },
        error: function(xhr, status, error) {
            if (errorCallback) {
                errorCallback(xhr, status, error);
            } else {
                showMessage('请求失败: ' + error, 'error');
            }
        }
    });
}
