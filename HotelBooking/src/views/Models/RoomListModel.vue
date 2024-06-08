<template>
    <ion-list>
        <ion-item v-for="(room, index) in paginatedRooms" :key="room.id" @click="selectRoom(room.id)">
            <img :src="getImagePath(index)" alt="Room Image" class="room-image" />
            <ion-checkbox slot="start" :checked="selectedRoomId === room.id"></ion-checkbox>
            <ion-label>
                <h3>{{ room.title }}</h3>
                <p>{{ room.description }}</p>
                <ExtrasList :extras="room.extras" />
            </ion-label>
        </ion-item>
    </ion-list>
</template>

<script lang="ts">
import { IonList, IonItem, IonLabel, IonCheckbox } from '@ionic/vue';
import ExtrasList from './ExtrasListModel.vue'
import { PropType } from 'vue';

export default {
    name: 'RoomList',
    components: {
        IonList,
        IonItem,
        IonLabel,
        IonCheckbox,
        ExtrasList
    },
    props: {
        paginatedRooms: {
            type: Array as () => { id: number; title: string; description: string; extras: string[] }[],
            required: true
        },
        selectedRoomId: {
            type: [Number, null] as PropType<number | null>,
            default: null
        }
    },
    emits: ['selectRoom'],
    methods: {
        getImagePath(index: number) {
            return `/Rooms/room${index + 1}.jpg`;
        },
        selectRoom(roomId: number) {
            this.$emit('selectRoom', roomId);
        }
    }
};
</script>

<style scoped>
.room-image {
    width: 100px;
    height: auto;
    margin-right: 10px;
}
</style>
