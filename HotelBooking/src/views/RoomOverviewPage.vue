<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">Room Overview</ion-title>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <h1>Our Rooms</h1>
            <ion-list>
                <ion-item v-for="room in rooms" :key="room.id">
                    <ion-label>
                        <h3>{{ room.title }}</h3>
                        <p>{{ room.description }}</p>
                        <ul class="extras-list">
                            <li v-for="extra in room.extras" :key="extra" class="extra-item">
                                <ion-icon :icon="getIcon(extra)"></ion-icon>
                                {{ extra }}
                            </li>
                        </ul>
                    </ion-label>
                </ion-item>
            </ion-list>
            <ion-button class="return-button" @click="navigateToWelcome">Return</ion-button>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonList, IonItem, IonLabel, IonIcon, IonButton } from '@ionic/vue';
import { wifiOutline, snowOutline, wineOutline, volumeMuteOutline, tvOutline, checkmarkCircleOutline } from 'ionicons/icons';
import axios from 'axios';

export default {
    name: 'RoomOverviewPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonList,
        IonItem,
        IonLabel,
        IonButton,
        IonIcon
    },
    data() {
        return {
            rooms: []
        };
    },
    mounted() {
        this.fetchRooms();
    },
    methods: {
        async fetchRooms() {
            try {
                const response = await axios.get('https://your-backend-api-url/rooms');
                if (response.data && response.data.length > 0) {
                    this.rooms = response.data;
                } else {
                    this.setDefaultRoom();
                }
            } catch (error) {
                console.error('Error fetching rooms:', error);
                this.setDefaultRoom();
            }
        },
        setDefaultRoom() {
            this.rooms = [
                {
                    id: 0,
                    title: 'Default Room',
                    description: 'This is a default room description. This room is provided as an example in case the API call fails or returns no data.',
                    extras: ['Free WiFi', 'Noise Protection', 'Tv']
                }
            ];
        },
        navigateToWelcome() {
            this.$router.push('/');
        },
        getIcon(extra: string) {
            switch (extra.toLowerCase()) {
                case 'free wifi':
                    return wifiOutline;
                case 'air conditioning':
                    return snowOutline;
                case 'mini bar':
                    return wineOutline;
                case 'noise protection':
                    return volumeMuteOutline;
                case 'tv':
                    return tvOutline;
                default:
                    return checkmarkCircleOutline;
            }
        }
    }
};
</script>

<style scoped>
.return-button {
    position: fixed;
    bottom: 16px;
    right: 16px;
    z-index: 100;
}

.extras-list {
    list-style-type: none;
    padding: 0;
}

.extra-item {
    display: flex;
    align-items: center;
}

.extra-item ion-icon {
    margin-right: 8px;
}
</style>