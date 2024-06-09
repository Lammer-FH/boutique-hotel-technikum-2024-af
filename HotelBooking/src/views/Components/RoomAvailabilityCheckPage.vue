<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-button @click="navigateBack">
                    <ion-icon slot="icon-only" :icon="arrowBackOutline"></ion-icon>
                </ion-button>
                <IonTitle slot="end">When would you like to visit us?</IonTitle>
            </IonToolbar>
        </IonHeader>
        <IonContent class="ion-padding">
            <div class="form-container">
                <h1 class="page-title">Check Room Availability</h1>
                <form @submit.prevent="checkAvailability" class="availability-form">
                    <IonItem class="form-item">
                        <IonLabel position="floating">Arrival Date</IonLabel>
                        <IonInput type="date" v-model="arrivalDate" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Departure Date</IonLabel>
                        <IonInput type="date" v-model="departureDate" required></IonInput>
                    </IonItem>
                    <IonItem class="form-item">
                        <IonLabel position="floating">Number of Persons</IonLabel>
                        <IonInput type="number" v-model="numberOfPersons" min="1" required></IonInput>
                    </IonItem>
                    <div class="availability-button-container">
                        <ion-button type="submit" color="mygreen" class="availability-button">Check
                            Availability</ion-button>
                    </div>
                </form>
            </div>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon, IonItem, IonLabel, IonInput } from '@ionic/vue';
import { arrowBackOutline } from 'ionicons/icons';
import { defineComponent } from 'vue';
import { useRoute } from 'vue-router';

export default defineComponent({
    name: 'RoomAvailabilityCheckPage',
    components: {
        IonPage,
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonButton,
        IonIcon,
        IonItem,
        IonLabel,
        IonInput,
    },
    data() {
        return {
            arrivalDate: '',
            departureDate: '',
            numberOfPersons: 1,
            roomId: null as number | null,
        };
    },
    created() {
        const route = useRoute();
        this.roomId = Number(route.params.roomId);
    },
    setup() {
        return {
            arrowBackOutline,
        };
    },
    methods: {
        navigateBack() {
            this.$router.back();
        },
        checkAvailability() {
            alert(`Checking availability for Room ID: ${this.roomId}, Arrival Date: ${this.arrivalDate}, Departure Date: ${this.departureDate}, Number of Persons: ${this.numberOfPersons}`);
        },
    },
});
</script>

<style scoped>
.page-title {
    text-align: center;
    font-size: 2em;
    margin-bottom: 20px;
}

.form-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100%;
}

.availability-form {
    width: 100%;
    max-width: 500px;
    padding: 20px;
    background: var(--ion-color-light);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.form-item {
    --highlight-height: 2px;
    --highlight-color-focused: var(--ion-color-primary);
    --inner-padding-top: 10px;
    --padding-bottom: 10px;
}

.form-item ion-label {
    margin-bottom: 10px;
}

.availability-button-container {
    display: flex;
    justify-content: center;
}

.availability-button {
    width: 100%;
    max-width: 20em;
    font-size: 1.2em;
}

ion-input {
    --padding-start: 8px;
    font-size: 1.2em;
}

ion-label {
    --color: var(--ion-color-primary);
    font-size: 1.2em;
}

ion-button {
    --background: var(--ion-color-primary);
    --background-hover: var(--ion-color-primary-shade);
    --background-activated: var(--ion-color-primary-tint);
    --border-radius: 8px;
    --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

@media (max-width: 767px) {
    .availability-form {
        width: 100%;
        max-width: 100%;
        padding: 10px;
    }

    .availability-button {
        font-size: 1em;
    }
}
</style>
