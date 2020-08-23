import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PorGeneroComponent } from './por-genero.component';

describe('PorGeneroComponent', () => {
  let component: PorGeneroComponent;
  let fixture: ComponentFixture<PorGeneroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PorGeneroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PorGeneroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
