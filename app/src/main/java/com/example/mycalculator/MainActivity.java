package com.example.mycalculator;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.textView);
        display = findViewById(R.id.textScreen);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void sevenBTNPush(View view) {
        updateText("7");
    }

    public void eightBTNPush(View view) {
        updateText("8");
    }

    public void nineBTNPush(View view) {
        updateText("9");
    }

    public void fourBTNPush(View view) {
        updateText("4");
    }

    public void fiveBTNPush(View view) {
        updateText("5");
    }

    public void sixBTNPush(View view) {
        updateText("6");
    }

    public void oneBTNPush(View view) {
        updateText("1");
    }

    public void twoBTNPush(View view) {
        updateText("2");
    }

    public void threeBTNPush(View view) {
        updateText("3");
    }

    public void zeroBTNPush(View view) {
        updateText("0");
    }

    public void addBTNPush(View view) {
        updateText("+");
    }

    public void subtractBTNPush(View view) {
        updateText("-");
    }

    public void multiplyBTNPush(View view) {
        updateText("×");
    }

    public void divideBTNPush(View view) {
        updateText("÷");
    }

    public void dotBTNPush(View view) {
        updateText(".");
    }

    public void openBTNPush(View view) {
        updateText("(");
    }

    public void closeBTNPush(View view) {
        updateText(")");
    }

    public void clearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }

    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.division), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.btn_multp), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());


        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void sinBTNPush(View view){
        updateText("sin(pi/180*");
    }

    public void cosBTNPush(View view){
        updateText("cos(pi/180*");
    }

    public void tanBTNPush(View view){
        updateText("tan(pi/180*");
    }

    public void arcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void arcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void arcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void lnBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void factorielBTNPush(View view){
        updateText("!");
    }
}