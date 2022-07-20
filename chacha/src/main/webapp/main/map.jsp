<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
	margin: 0;
}
</style>
</head>
<body>
<div id="map" style="width:100%;height:100vh;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1b4ff6e20d754b853ba624fa3a2f172d"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(35.8660426, 128.5938422), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	// 현재 위치 좌표
	var markerPosition  = new kakao.maps.LatLng(35.8660426, 128.5938422);
	var markerPosition2 = new kakao.maps.LatLng(35.8665196, 128.5943343);
	
	// 마커 생성
	var marker = new kakao.maps.Marker({
        position: markerPosition
    });
	var marker2 = new kakao.maps.Marker({
        position: markerPosition2
    });
	
	// 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div class="map-info-window">현재 위치</div>'
    });
    infowindow.open(map, marker);
    
 	// 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
 	marker2.setMap(map);

    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
    // marker.setMap(null);
</script>
</body>
</html>