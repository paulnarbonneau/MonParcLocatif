import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mpl-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  implements OnInit{
  ngOnInit(): void {

    
  }
  

  playAudio()
  {
    
    let audio = new Audio();
    audio.src= "/assets/sounds/Bourriquet.mp3";
    audio.play();
    console.log("chargement audio");
  }
  title = 'mpl-ui';




}
