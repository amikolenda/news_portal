import { Author } from './author.model';
export class News {
  id?: any;
  title?: string;
  text?: string;
  date_time_created? : Date;
  author?: Author;
  img? :string;
  published?: boolean;
}
