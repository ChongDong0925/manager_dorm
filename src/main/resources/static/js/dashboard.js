// 大屏专用JS

// 页面加载完成后执行
$(document).ready(function() {
    // 初始化视频播放
    initVideoPlayback();
    
    // 初始化图表
    initCharts();
    
    // 定时刷新数据
    setInterval(refreshData, 30000); // 每30秒刷新一次
});

// 初始化视频播放
function initVideoPlayback() {
    // 获取所有视频元素
    var videos = document.querySelectorAll('video');
    
    // 为每个视频添加播放控制
    videos.forEach(function(video) {
        // 自动播放
        video.autoplay = true;
        // 静音
        video.muted = true;
        // 循环播放
        video.loop = true;
        
        // 视频加载完成后播放
        video.addEventListener('loadedmetadata', function() {
            this.play();
        });
        
        // 视频播放出错时的处理
        video.addEventListener('error', function() {
            console.error('视频播放出错:', this.src);
        });
    });
}

// 初始化图表
function initCharts() {
    // 任务数量统计图表
    initTaskChart();
    
    // 出勤趋势图表
    initAttendanceChart();
    
    // 任务完成率图表
    initCompletionChart();
}

// 初始化任务数量统计图表
function initTaskChart() {
    var taskChart = echarts.init(document.getElementById('taskChart'));
    
    // 从服务器获取数据
    $.ajax({
        url: '/api/visual/taskStatistics',
        method: 'GET',
        success: function(data) {
            var option = {
                title: {
                    text: '任务数量统计',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['维修', '养护', '清扫'],
                    bottom: 0,
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: ['任务类型'],
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    },
                    splitLine: {
                        lineStyle: {
                            color: 'rgba(100, 116, 139, 0.3)'
                        }
                    }
                },
                series: [
                    {
                        name: '维修',
                        type: 'bar',
                        data: [data.repairCount || 0],
                        itemStyle: {
                            color: '#3b82f6'
                        }
                    },
                    {
                        name: '养护',
                        type: 'bar',
                        data: [data.maintenanceCount || 0],
                        itemStyle: {
                            color: '#10b981'
                        }
                    },
                    {
                        name: '清扫',
                        type: 'bar',
                        data: [data.cleaningCount || 0],
                        itemStyle: {
                            color: '#f59e0b'
                        }
                    }
                ]
            };
            taskChart.setOption(option);
        },
        error: function() {
            // 使用模拟数据
            var option = {
                title: {
                    text: '任务数量统计',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['维修', '养护', '清扫'],
                    bottom: 0,
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: ['任务类型'],
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    },
                    splitLine: {
                        lineStyle: {
                            color: 'rgba(100, 116, 139, 0.3)'
                        }
                    }
                },
                series: [
                    {
                        name: '维修',
                        type: 'bar',
                        data: [15],
                        itemStyle: {
                            color: '#3b82f6'
                        }
                    },
                    {
                        name: '养护',
                        type: 'bar',
                        data: [10],
                        itemStyle: {
                            color: '#10b981'
                        }
                    },
                    {
                        name: '清扫',
                        type: 'bar',
                        data: [8],
                        itemStyle: {
                            color: '#f59e0b'
                        }
                    }
                ]
            };
            taskChart.setOption(option);
        }
    });
    
    // 响应式调整
    window.addEventListener('resize', function() {
        taskChart.resize();
    });
}

// 初始化出勤趋势图表
function initAttendanceChart() {
    var attendanceChart = echarts.init(document.getElementById('attendanceChart'));
    
    // 从服务器获取数据
    $.ajax({
        url: '/api/visual/attendanceTrend',
        method: 'GET',
        success: function(data) {
            var option = {
                title: {
                    text: '出勤趋势',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['正常', '迟到', '缺勤'],
                    bottom: 0,
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: data.dates || ['1月1日', '1月2日', '1月3日', '1月4日', '1月5日', '1月6日', '1月7日'],
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    },
                    splitLine: {
                        lineStyle: {
                            color: 'rgba(100, 116, 139, 0.3)'
                        }
                    }
                },
                series: [
                    {
                        name: '正常',
                        type: 'line',
                        data: data.normalCounts || [45, 48, 50, 47, 52, 55, 58],
                        smooth: true,
                        itemStyle: {
                            color: '#10b981'
                        },
                        lineStyle: {
                            width: 3
                        }
                    },
                    {
                        name: '迟到',
                        type: 'line',
                        data: data.lateCounts || [8, 6, 5, 7, 4, 3, 2],
                        smooth: true,
                        itemStyle: {
                            color: '#f59e0b'
                        },
                        lineStyle: {
                            width: 3
                        }
                    },
                    {
                        name: '缺勤',
                        type: 'line',
                        data: data.absentCounts || [2, 1, 2, 1, 0, 1, 0],
                        smooth: true,
                        itemStyle: {
                            color: '#ef4444'
                        },
                        lineStyle: {
                            width: 3
                        }
                    }
                ]
            };
            attendanceChart.setOption(option);
        },
        error: function() {
            // 使用模拟数据
            var option = {
                title: {
                    text: '出勤趋势',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['正常', '迟到', '缺勤'],
                    bottom: 0,
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    data: ['1月1日', '1月2日', '1月3日', '1月4日', '1月5日', '1月6日', '1月7日'],
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#64748b'
                        }
                    },
                    axisLabel: {
                        color: '#e2e8f0'
                    },
                    splitLine: {
                        lineStyle: {
                            color: 'rgba(100, 116, 139, 0.3)'
                        }
                    }
                },
                series: [
                    {
                        name: '正常',
                        type: 'line',
                        data: [45, 48, 50, 47, 52, 55, 58],
                        smooth: true,
                        itemStyle: {
                            color: '#10b981'
                        },
                        lineStyle: {
                            width: 3
                        }
                    },
                    {
                        name: '迟到',
                        type: 'line',
                        data: [8, 6, 5, 7, 4, 3, 2],
                        smooth: true,
                        itemStyle: {
                            color: '#f59e0b'
                        },
                        lineStyle: {
                            width: 3
                        }
                    },
                    {
                        name: '缺勤',
                        type: 'line',
                        data: [2, 1, 2, 1, 0, 1, 0],
                        smooth: true,
                        itemStyle: {
                            color: '#ef4444'
                        },
                        lineStyle: {
                            width: 3
                        }
                    }
                ]
            };
            attendanceChart.setOption(option);
        }
    });
    
    // 响应式调整
    window.addEventListener('resize', function() {
        attendanceChart.resize();
    });
}

// 初始化任务完成率图表
function initCompletionChart() {
    var completionChart = echarts.init(document.getElementById('completionChart'));
    
    // 从服务器获取数据
    $.ajax({
        url: '/api/visual/taskCompletionRate',
        method: 'GET',
        success: function(data) {
            var option = {
                title: {
                    text: '任务完成率',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                series: [
                    {
                        name: '任务状态',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            {value: data.completedTasks || 20, name: '已完成'},
                            {value: data.totalTasks - (data.completedTasks || 20), name: '未完成'}
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        itemStyle: {
                            color: function(params) {
                                var colors = ['#10b981', '#64748b'];
                                return colors[params.dataIndex];
                            }
                        },
                        label: {
                            color: '#ffffff'
                        }
                    }
                ]
            };
            completionChart.setOption(option);
        },
        error: function() {
            // 使用模拟数据
            var option = {
                title: {
                    text: '任务完成率',
                    left: 'center',
                    textStyle: {
                        color: '#ffffff'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    textStyle: {
                        color: '#e2e8f0'
                    }
                },
                series: [
                    {
                        name: '任务状态',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            {value: 20, name: '已完成'},
                            {value: 10, name: '未完成'}
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        itemStyle: {
                            color: function(params) {
                                var colors = ['#10b981', '#64748b'];
                                return colors[params.dataIndex];
                            }
                        },
                        label: {
                            color: '#ffffff'
                        }
                    }
                ]
            };
            completionChart.setOption(option);
        }
    });
    
    // 响应式调整
    window.addEventListener('resize', function() {
        completionChart.resize();
    });
}

// 刷新数据
function refreshData() {
    console.log('刷新数据...');
    
    // 重新初始化图表
    initCharts();
    
    // 重新初始化视频播放
    initVideoPlayback();
}
