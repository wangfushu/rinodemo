function getWindGrade(windSpeed) {
    var wind = 0;
    if(windSpeed == null || windSpeed <= 0.2){
        wind = 0;
    }else if(windSpeed <= 1.6){
        wind = 1;
    }else if(windSpeed <= 3.4){
        wind = 2;
    }else if(windSpeed <= 5.5){
        wind = 3;
    }else if(windSpeed <= 8.0){
        wind = 4;
    }else if(windSpeed <= 10.8){
        wind = 5;
    }else if(windSpeed <= 13.9){
        wind = 6;
    }else if(windSpeed <= 17.2){
        wind = 7;
    }else if(windSpeed <= 20.8){
        wind = 8;
    }else if(windSpeed <= 24.5){
        wind = 9;
    }else if(windSpeed <= 28.5){
        wind = 10;
    }else if(windSpeed <= 32.6){
        wind = 11;
    }else if(windSpeed <= 37.0){
        wind = 12;
    }else if(windSpeed <= 41.4){
        wind = 13;
    }else if(windSpeed <= 46.1){
        wind = 14;
    }else if(windSpeed <= 50.9){
        wind = 15;
    }else if(windSpeed <= 56.0){
        wind = 16;
    }else if(windSpeed <= 61.2){
        wind = 17;
    }else if(windSpeed >61.2){
        wind = "17级以上";
    }
    return wind;
}

function getUserOption(num1,num2,num3) {
    var app = {};
    option = null;
    app.title = '条形图';
    option = {
        xAxis: {
            show:true,
            type: 'category',

        },
        yAxis: {
            type: 'value',
            show:false,
        },
        legend:{
            type:'plain',
            align:'right',
            top:0,
        },
        series: [{
            label:true,
            data: [num1],
            type: 'bar',
            color:["#10c469"],
        },{
            type: 'bar',
            z: 10,
            data: [num2],
            color:["#00aff0"],
        },{
            type: 'bar',
            z: 10,
            data: [num3],
            color:["#ffc028"],
        }]
    };
    return option;
}

function getId(id) {
    return document.getElementById(id);
}