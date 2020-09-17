import { TestBed } from '@angular/core/testing';

import { ProductsellService } from './productsell.service';

describe('ProductsellService', () => {
  let service: ProductsellService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductsellService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
