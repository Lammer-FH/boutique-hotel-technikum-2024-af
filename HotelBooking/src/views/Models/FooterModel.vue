<template>
    <ion-footer>
        <ion-toolbar>
            <ion-buttons slot="start">
                <ion-button @click="$router.push('about')">About</ion-button>
            </ion-buttons>
            <ion-buttons slot="end">
                <ion-button @click="$router.push('imprint')">Imprint</ion-button>
            </ion-buttons>
        </ion-toolbar>
    </ion-footer>
</template>

<script lang="ts">
import { IonFooter, IonToolbar, IonButton, IonButtons } from '@ionic/vue';

export default {
    name: 'FooterPage',
    components: {
        IonFooter,
        IonToolbar,
        IonButton,
        IonButtons
    },
};
</script>