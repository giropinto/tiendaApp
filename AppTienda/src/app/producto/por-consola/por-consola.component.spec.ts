import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PorConsolaComponent } from './por-consola.component';

describe('PorConsolaComponent', () => {
  let component: PorConsolaComponent;
  let fixture: ComponentFixture<PorConsolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PorConsolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PorConsolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
