export class HotelDto {
    
  private nome: string = '';
  private id: string = '';
  private city: string = '';
  public main_photo_url: string = '';
    
  getNome(): string {
    return this.nome;
  }
    
  setNome(value: string) {
    this.nome = value;
  }
    
  getId(): string {
    return this.id;
  }
    
  setId(value: string) {
    this.id = value;
  }
    
  getCity(): string {
    return this.city;
  }
    
  setCity(value: string) {
    this.city = value;
  }

  getMain_photo_url(): string {
    return this.main_photo_url;
  }
    
  setMain_photo_url(value: string) {
    this.main_photo_url = value;
  }
  
  constructor(nome: string = '', id: string = '', city: string = '', main_photo_url: string = '') {
    this.nome = nome;
    this.id = id;
    this.city = city;
    this.main_photo_url = main_photo_url
  }
}
