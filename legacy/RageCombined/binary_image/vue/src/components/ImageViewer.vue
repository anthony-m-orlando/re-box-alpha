<template>
    <div v-for="id in imageIds" v-bind:key="id">
        <img v-bind:src=imageURL+id>
    </div>
</template>

<script>
import ImageService from "../services/ImageService"

export default {
    data() {
        return {
            imageURL: "http://localhost:9000/images/",
            imageIds: []
        };
    },
    methods: {
        getImages() {
            ImageService.getImageIds()
            .then(response => {
                this.imageIds = response.data;
                console.log(response.data);
            })
            .catch(error =>{
                console.log(error);
            })
        }
    },
    created() {
            this.getImages();
        }
}
</script>
