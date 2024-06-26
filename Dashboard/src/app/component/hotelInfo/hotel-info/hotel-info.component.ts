import { Component } from '@angular/core';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { HotelInfoDto } from 'src/app/shared/models/hotelInfo.dto';

@Component({
  selector: 'app-hotel-info',
  templateUrl: './hotel-info.component.html',
  styleUrls: ['./hotel-info.component.scss']
  
})
export class HotelInfoComponent {

  constructor(private hotelSevice: HotelService, ){}

  hotel: HotelInfoDto | undefined

  id!: string;

  foto: string = ''

  ngOnInit(){

    this.foto = this.hotelSevice.fotoHotel;
    this.hotel = this.hotelSevice.hotelInfo;
    console.log(this.hotel)

  }

}
