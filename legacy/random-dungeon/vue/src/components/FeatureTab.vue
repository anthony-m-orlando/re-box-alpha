<template>
    
    <label>Features in the Dungeon</label>
    <div class="row" style="width: 15rem;" v-for="(feature, index) in this.$store.state.features" v-bind:key="feature">
        <div class="collapsible">
            <input v-bind:id="'collapsible-feature-' + index" type="checkbox" name="collapsible">
            <label v-bind:for="'collapsible-feature-' + index">{{index+1}} {{ feature.featureName }}</label>
            <div class="collapsible-body">
                <select>
                    <option>Untouched</option> 
                    <option>Collected</option>    
                    <option>Destroyed</option>   
            </select>
                <div class="card" style="width: 20rem;">
                    <div class="card-body">
                       <p><img v-bind:src="`src/assets/icons/features/${feature.imageName}`"></p>
                        <h4 class="card-title">Feature{{index + 1}}) - {{ feature.featureName }}</h4>
                        <h5>{{ feature.featureDescription }} </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

