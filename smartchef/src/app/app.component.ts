import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import {personOutline, checkmarkDoneCircleOutline,returnUpBackOutline,
  checkmarkOutline,personAddOutline,heartOutline,
  timeOutline,leafOutline,homeOutline,searchOutline,addCircleOutline,closeOutline} from "ionicons/icons";
import {addIcons} from "ionicons";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet],
})
export class AppComponent {
  constructor() {
    addIcons({
      personOutline,
      checkmarkDoneCircleOutline,
      returnUpBackOutline,
      checkmarkOutline,
      personAddOutline,
      heartOutline,
      timeOutline,
      leafOutline,
      homeOutline,
      searchOutline,
      addCircleOutline,
      closeOutline
    })
  }
}
