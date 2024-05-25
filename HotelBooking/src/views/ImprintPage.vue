<template>
    <ion-page>
        <IonHeader>
            <IonToolbar>
                <ion-title slot="end">Imprint</ion-title>
            </IonToolbar>
        </IonHeader>

        <IonContent class="ion-padding">
            <h2>Legal Information</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur ligula in orci suscipit,
                eget lobortis nunc laoreet. Nullam et libero ac justo posuere fringilla at vel dui. Sed rutrum magna et
                nisi eleifend, vel interdum magna faucibus. Nam ac interdum justo. Vivamus auctor, tortor ut molestie
                mollis, arcu ipsum venenatis urna, vel vulputate purus risus nec justo. Nam fermentum ante quis dapibus
                tristique. Nam ac lacus ut nisl vestibulum interdum.
            </p>
            <p>
                Phasellus sagittis mi nec elit lobortis posuere. Vivamus hendrerit diam id diam vehicula efficitur.
                Curabitur convallis efficitur massa, ut suscipit mauris varius id. Vivamus eget bibendum velit. Ut id
                urna semper, suscipit lacus ac, sollicitudin magna. Fusce eget ullamcorper erat. Duis tincidunt, odio ac
                efficitur laoreet, nisi libero tincidunt enim, vitae maximus urna risus non metus. Curabitur eleifend,
                velit non posuere tincidunt, nulla turpis vehicula eros, at hendrerit ante nisi vel lorem. Integer ut
                fermentum eros, id pharetra felis. In tincidunt, ipsum sed volutpat tempor, nunc sapien finibus elit, ut
                varius neque ante non mauris.
            </p>
            <p>
                Aenean ut nisi vel ante commodo blandit in et ligula. Morbi eleifend odio eu dapibus convallis.
                Suspendisse potenti. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac
                turpis egestas. Ut tempus sapien sit amet magna dignissim fermentum. Duis fringilla, risus in
                condimentum interdum, velit lorem varius turpis, nec ultricies neque dolor nec felis. Nulla facilisi.
                Nulla ut semper justo, a efficitur nunc. Vivamus posuere nunc a felis malesuada, at laoreet velit
                luctus. Ut eget lacus a justo congue feugiat. Fusce fringilla felis non mauris commodo, nec malesuada
                lorem viverra. Curabitur blandit lacinia velit nec vestibulum. Quisque non aliquam turpis, in consequat
                felis.
            </p>
            <ion-button class="return-button" @click="$router.push('/')">
                <ion-icon slot="icon-only" :icon="arrowBack"></ion-icon>
            </ion-button>
        </IonContent>
    </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon } from '@ionic/vue';
import { arrowBack } from 'ionicons/icons';

export default {
    name: 'ImprintPage',
    components: { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonButton, IonIcon },
    setup() {
        return {
            arrowBack
        };
    }
};
</script>

<style scoped>
p {
    text-align: justify;
    padding-left: 40px;
    padding-right: 40px;
    font-size: 1.3em;
}

.return-button {
    position: fixed;
    bottom: 20px;
    right: 20px;
}
</style>