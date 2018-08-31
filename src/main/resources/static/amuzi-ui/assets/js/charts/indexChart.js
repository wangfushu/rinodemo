(function(){
	var myChart = echarts.init(document.getElementById("widget-chart-box-1"));
	var myChart2 = echarts.init(document.getElementById("widget-chart-box-2"));

	var labelTop = {
		
    normal : {
        label : {
            show : true,
            position : 'center',
            formatter : '{b}',
            textStyle: {
                baseline : 'bottom'
            }
        },
        labelLine : {
            show : false
        }
        
    }
};
var labelFromatter = {
    normal : {
        label : {
            formatter : function (params){
                return 100 - params.value + '%'
            },
            textStyle: {
                baseline : 'center'
            }
        }
    },
}
var labelBottom = {
    normal : {
        color: '#ccc',
        label : {
            show : true,
            position : 'center'
        },
        labelLine : {
            show : false
        }
    },
    emphasis: {
        color: '#ccc'
    }
};
var radius = [40, 35];
option = {
	
	
	
    legend: {
        x : 'center',
        y : 'center',
        
    },
    
    grid: {
    	x:0,
    	y:0,
    	x2:0,
    	y2:0
    },
    
    toolbox: {
        show : true,
        feature : {
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        width: '20%',
                        height: '30%',
                        itemStyle : {
                            normal : {
                                label : {
                                    formatter : function (params){
                                        return 'other\n' + params.value + '%\n'
                                    },
                                    textStyle: {
                                        baseline : 'middle'
                                    }
                                }
                            },
                        } 
                    }
                }
            }
           
        }
    },
    series : [
        {
            type : 'pie',
            
            radius : radius,
            x: '0%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:46, itemStyle : labelBottom},
                {name:'', value:54,itemStyle : labelTop}
            ]
        }
        
    ],
    animation :false
};

	myChart.setOption(option);
	myChart2.setOption(option);
})();

(function(){
    var myChart = echarts.init(document.getElementById("index-pie-1"));

    var labelTop = {

        normal : {
            label : {
                show : true,
                position : 'center',
                formatter : '{b}',
                textStyle: {
                    baseline : 'bottom'
                }
            },
            labelLine : {
                show : false
            }

        }
    };
    var labelFromatter = {
        normal : {
            label : {
                formatter : function (params){
                    return 100 - params.value + '%'
                },
                textStyle: {
                    baseline : 'center'
                }
            }
        },
    }
    var labelBottom = {
        normal : {
            color: '#ccc',
            label : {
                show : true,
                position : 'center'
            },
            labelLine : {
                show : false
            }
        },
        emphasis: {
            color: '#ccc'
        }
    };
    var radius = [40, 35];
    option = {



        legend: {
            x : 'center',
            y : 'center',

        },

        grid: {
            x:0,
            y:0,
            x2:0,
            y2:0
        },

        toolbox: {
            show : true,
            feature : {
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            width: '20%',
                            height: '30%',
                            itemStyle : {
                                normal : {
                                    label : {
                                        formatter : function (params){
                                            return 'other\n' + params.value + '%\n'
                                        },
                                        textStyle: {
                                            baseline : 'middle'
                                        }
                                    }
                                },
                            }
                        }
                    }
                }

            }
        },
        series : [
            {
                type : 'pie',

                radius : radius,
                x: '0%', // for funnel
                itemStyle : labelFromatter,
                data : [
                    {name:'other', value:46, itemStyle : labelBottom},
                    {name:'', value:54,itemStyle : labelTop}
                ]
            }

        ],
        animation :false
    };


    myChart.setOption(option);
})();


(function(){
	var myChart = echarts.init(document.getElementById("index-bar-1"));
    var str = new Array();
    var instr = new Array();
    for(i = 0;i<5;i++){
        str[i] = i+"str";
        instr[i] = (i+1)*10;
    }
	option = {
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : str,
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'直接访问',
            type:'bar',
            barWidth: '60%',
            data:instr
        }
    ]
};

                    
                    
	
	myChart.setOption(option);
})();



(function(){
	var myChart = echarts.init(document.getElementById("index-line-1"));
	
	option = {

    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['最高气温','最低气温'],
        x: "right"
    },
    
    xAxis:  {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} °C'
        }
    },
    series: [
        {
            name:'最高气温',
            type:'line',
            data:[11, 11, 15, 13, 12, 13, 10],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'最低气温',
            type:'line',
            data:[1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [
                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'},
                    [{
                        symbol: 'none',
                        x: '90%',
                        yAxis: 'max'
                    }, {
                        symbol: 'circle',
                        label: {
                            normal: {
                                position: 'start',
                                formatter: '最大值'
                            }
                        },
                        type: 'max',
                        name: '最高点'
                    }]
                ]
            }
        }
    ]
};
	myChart.setOption(option);
})();

(function () {
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '环形图';

    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },color:["#000000","#cccccc"],
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['60%', '70%'],
                avoidLabelOverlap: false,
                itemStyle : labelFromatter,
                label: {
                    normal: {
                        show: true,
                        position: 'center'
                    },
                    emphasis: {
                        show: false,
                        textStyle: {
                            fontSize: '12',
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:82, name:'直接访问',itemStyle:labelBottom},
                    {value:18, name:'邮件营销',itemStyle:labelBottom},
                ]
            }
        ]
    };
    var labelBottom = {
        normal : {
            color: '#ccc',
            label : {
                show : true,
                position : 'center'
            },
            labelLine : {
                show : false
            }
        },
        emphasis: {
            color: '#ccc'
        }
    };
    var labelFromatter = {
        normal : {
            label : {
                formatter : function (params){
                    return 100 - params.value + '%'
                },
                textStyle: {
                    baseline : 'center'
                }
            }
        },
    }
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }

})();
