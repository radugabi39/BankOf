import { BankOfUIPage } from './app.po';

describe('bank-of-ui App', function() {
  let page: BankOfUIPage;

  beforeEach(() => {
    page = new BankOfUIPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
