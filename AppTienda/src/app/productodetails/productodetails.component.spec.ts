import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductodetailsComponent } from './productodetails.component';

describe('ProductodetailsComponent', () => {
  let component: ProductodetailsComponent;
  let fixture: ComponentFixture<ProductodetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductodetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductodetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
