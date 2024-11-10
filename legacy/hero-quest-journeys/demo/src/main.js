function mapView(size) {
    img = document.getElementById('view-map');
    if (size === '100') {
        img.src = '/public/img/maps/world-map.jpg';
    } else if (size === '50') {
        img.src = '/public/img/maps/world-map-med.jpg';
    } else {
        img.src = '/public/img/maps/world-map-small.jpg';
    }
    img.src = 'images/map-100.png';
}