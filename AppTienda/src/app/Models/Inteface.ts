export interface UsuarioRequest{
  username: string;
  contrasenia: string;
  nombres: string;
  apellidos: string;
}
export interface UsuarioResponse{
  username: string;
  contrasenia: string;
  nombres: string;
  apellidos: string;
}
export interface CulqiTokenRequest{
  card_number: string;
  cvv: string;
  expiration_month: string;
  expiration_year: string;
  email: string;
}
export interface CulqiPagoRequest{
  amount: string;
  currency_code: string;
  email: string;
  source_id: string;
}
