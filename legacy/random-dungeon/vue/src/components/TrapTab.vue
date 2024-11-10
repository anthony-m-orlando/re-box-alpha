<template>
    <label>Traps in the Dungeon</label>
    <div class="row" style="width: 15rem;" v-for="(trap, index) in this.$store.state.traps" v-bind:key="trap">
        <div class="collapsible">
            <input v-bind:id="'collapsible-trap-' + index" type="checkbox" name="collapsible">
            <label v-bind:for="'collapsible-trap-' + index">{{index+1}} {{ trap.name }}</label>
            <div class="collapsible-body">
                <select>
                    <option>Active</option> 
                    <option>Disabled</option>    
                    <option>Triggered</option>   
            </select>
                <div class="card" style="width: 20rem;">
                    <div class="card-body">
                       <p><img v-bind:src="`src/assets/icons/traps/${trap.imageFile}`"></p>
                        <h4 class="card-title">Trap{{index + 1}}) - {{ trap.name }}</h4>
                        <h4 class="card-title">Disable DC: {{trap.disableDC}}</h4>
                        <h5 v-if="trap.visible">{{ trap.description }} </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
export default {
  
}
</script>

<style>
  .trap-label {
        border-radius: 5px;
        border: 2px solid whitesmoke;
    }
</style>